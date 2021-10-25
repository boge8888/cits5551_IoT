#!/usr/bin/python
from sense_hat import SenseHat
import pymysql
import time
import datetime
import numpy as np

# con = pymysql.connect(
#     host='120.78.146.114',
#     port=3306,
#     user='sensors',
#     password='raspberryproject',
#     db='sensors',
#     charset='utf8'
# )
# cur = con.cursor()
# cur.execute("select * from data")
# data = cur.fetchall()
# print(data)



sense = SenseHat()

# 设置旋转方向，可选0,90,180,270，默认为0
sense.set_rotation(180)

# 设置颜色R G B值
color_text = (0, 0, 255)
color_back = (0, 0, 0)

sense.set_imu_config(compass_enabled=False, gyro_enabled=True, accel_enabled=False)

#initialize the connection to database
db = pymysql.connect(
        host='120.78.146.114',
        port=3306,
        user='sensors',
        password='raspberryproject',
        db='sensors',
        charset='utf8'
    )
#initialize the cursor
cursor = db.cursor()

selection = input("type in 't' for bridge tower(tilter), 'c' for bridge cable(acceleration), 'd' for default(temperature, humidity, air pressure):")
if selection == 'c':
    #load the root-mean-square to acceleration in minutes from database
    sql = 'select acc from bridgecabledata'
    cursor.execute(sql)
    result = list(cursor.fetchall())
    history = []
    for i in range(0,len(result)):
        history.append(result[i][0])
    data = []
    for i in range(0,10000):
        temp = sense.get_temperature()
        # 获取传感器上的湿度值
        humidity = sense.humidity
        # 获取传感器上的大气压力值
        pressure = sense.get_pressure()
        # 加速度
        acc = sense.get_accelerometer_raw()
        acc="{x} {y} {z}".format(**acc)
        acc=acc.split(' ')
        acc=[float(a) for a in acc]
        acc = (acc[0]**2+acc[1]**2+acc[2]**2)**0.5*9.8
        data.append(acc)
        
        #calculate the riskLevel
        #the rootMeanSquare in one minute, if the data is more than 30, pop 1
        if (len(data)>30):
            data.pop(0)
        squaresum = 0
        for d in data:
            squaresum = squaresum + d**2
        rootMeanSquare = (squaresum/len(data))**0.5
        #append the new rootMeanSquare to history
        history.append(rootMeanSquare)
        while len(history)>365*24*60:
            history.pop(0)
        #calculate the mean
        sum = 0
        for h in history:
            if h!= None:
                sum = sum + h
        mean = sum/len(history)
        #calculate the standard deviation
        sum = 0
        for h in history:
            if h != None:
                sum = sum + (h-mean)**2
        sd = (sum/len(history))**0.5
        #calcualate the riskLevel
        
        risknum = abs(rootMeanSquare-mean)/(sd+0.01)
        if risknum>=4.5:
            riskLevel = 4
        elif risknum>=4:
            riskLevel = 3
        elif risknum>=3.5:
            riskLevel = 2
        elif risknum >= 3:
            riskLevel = 1
        else:
            riskLevel = 0
        #date time
        dt = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        print("rootMeanSquare in minutes: ",rootMeanSquare)
        print("annual mean to the rootMeanSquare: ",mean)
        print("annual standard devitation: ",sd)
        print("riskValue: ",risknum)
        #upload to the data list
        print("temperature:%.2f, humidity:%2f, air pressure:%2f, accleration:%2f, riskLevel:%i time:%s"%(temp,humidity,pressure,acc,riskLevel,dt))
        print("upload to data list...")
        sql = "INSERT INTO data(time, temperature, humidity, pressure) VALUES (\"%s\", %f, %f, %f)"\
            % (dt, temp, humidity, pressure)
        try:
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            db.rollback()
            print("rollback")
        #upload to bridgecable data list    
        print("upload to bridgecabledata list...")      
        sql = "INSERT INTO bridgecabledata(time, temperature,humidity,air_pressure,acc,risk_level) VALUES (\"%s\",%f, %f, %f, %f,%i)"\
            % (dt, temp, humidity, pressure, acc,riskLevel)
        try:
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            db.rollback()
            print("rollback")
        time.sleep(2)

elif selection == 'd':
    for i in range(1,10000):
        # 获取传感器上的温度值，以下多种获取温度的方式，选一种即可
        # temp = sense.temp
        # temp = sense.temperature
        # temp = sense.get_temperature_from_humidity()
        temp = sense.get_temperature()
        # 获取传感器上的湿度值
        humidity = sense.humidity
        # 获取传感器上的大气压力值
        pressure = sense.get_pressure()
        
        dt = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        
        print("temperature:%.2f, humidity:%2f, air pressure:%2f,time:%s"%(temp,humidity,pressure,dt))
        sql = "INSERT INTO data(time, temperature, humidity, pressure) VALUES (\"%s\", %f, %f, %f)"\
            % (dt, temp, humidity, pressure)
        try:
            print("upload to data list...")
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            db.rollback()
            print("rollback")
        time.sleep(2)

elif selection =='t':
    #load the tilter in two directions from database
    sql = 'select tilter_aline, tilter_vertical from bridgetowerdata'
    cursor.execute(sql)
    result = list(cursor.fetchall())
    history_aline = []
    history_vertical = []
    for i in range(0,len(result)):
        history_aline.append(result[i][0])
        history_vertical.append(result[i][1])
        
    for i in range(1,10000):
        # 获取传感器上的温度值，以下多种获取温度的方式，选一种即可
        # temp = sense.temp
        # temp = sense.temperature
        # temp = sense.get_temperature_from_humidity()
        temp = sense.get_temperature()
        # 获取传感器上的湿度值
        humidity = sense.humidity
        # 获取传感器上的大气压力值
        pressure = sense.get_pressure()
        
        gyr_degrees = sense.get_gyroscope()
        #pitch: alines to the birdge
        #roll: vertical to the bridge
        #yaw: third direction
        gyr_degrees = "{pitch} {roll} {yaw}".format(**gyr_degrees)
        gyr_degrees = gyr_degrees.split(' ')
        gyr_degrees = [float(g) for g in gyr_degrees][0:2]
        for j in range(0,len(gyr_degrees)):
            if gyr_degrees[j]>=180:
                gyr_degrees[j] = gyr_degrees[j] - 360
        
        history_aline.append(gyr_degrees[0])
        history_vertical.append(gyr_degrees[1])
        while(len(history_aline)>365*24*30):
            history_aline.pop(0)
        while(len(history_vertical)>365*24*30):
            history_vertical.pop(0)
        averageTilterAline = sum(history_aline)/len(history_aline)
        averageTilterVertical = sum(history_vertical)/len(history_vertical)
        sdAline=0
        for h in history_aline:
            sdAline = sdAline+(h-averageTilterAline)**2/len(history_aline)
        sdAline = sdAline**0.5
        sdVertical = 0
        for h in history_vertical:
            sdVertical = sdVertical+(h-averageTilterVertical)**2/len(history_vertical)
        sdVertical = sdVertical**0.5
        riskNumAline = abs(gyr_degrees[0]-averageTilterAline)/(sdAline+0.01)
        riskNumVertical = abs(gyr_degrees[1]-averageTilterVertical)/(sdVertical+0.01)
        risknum = max(riskNumAline, riskNumVertical)
        print(risknum)
        if risknum>=4:
            riskLevel = 4
        elif risknum>= 3:
            riskLevel = 2
        elif risknum>= 1:
            riskLevel = 1
        else:
            riskLevel = 0
        
        dt = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        print("temperature:%.2f, humidity:%2f, air pressure:%2f, tilter alines to the bridge:%.2f,tilter vertical to the bridge:%.2f, riskLevel:%i, time:%s"%(temp,humidity,pressure,gyr_degrees[0],gyr_degrees[1],riskLevel, dt))
        sql = "INSERT INTO bridgetowerdata(time, temperature, humidity, air_pressure, tilter_aline, tilter_vertical, risk_level) VALUES (\"%s\", %f, %f, %f, %f, %f, %i)"\
            % (dt, temp, humidity, pressure, gyr_degrees[0], gyr_degrees[1],riskLevel)
        print("upload to bridgetowerdata list...")
        try:
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            db.rollback()
            print("rollback")
        sql = "INSERT INTO data(time, temperature, humidity, pressure) VALUES (\"%s\", %f, %f, %f)"\
            % (dt, temp, humidity, pressure)
        try:
            print("upload to data list...")
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            db.rollback()
            print("rollback")
        time.sleep(2)
else:
    print("type in a wrong letter, please rerun the script")
    exit()
db.close()
