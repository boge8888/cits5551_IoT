#!/usr/bin/python
from sense_hat import SenseHat
import pymysql
import time
import datetime



sense = SenseHat()

# 设置旋转方向，可选0,90,180,270，默认为0; Set rotation direction, optional 0,90,180,270, default is 0
sense.set_rotation(180)

# 设置颜色R G B值; Set color R G B value
color_text = (0, 0, 255)
color_back = (0, 0, 0)


while True:
    # 获取传感器上的温度值，以下多种获取温度的方式，选一种即可; Get the temperature value on the sensor, the following kinds of ways to get the temperature, just choose one
    # temp = sense.temp
    # temp = sense.temperature
    # temp = sense.get_temperature_from_humidity()
    temp = sense.get_temperature()
    # 获取传感器上的湿度值; Get the humidity value on the sensor
    humidity = sense.humidity
    # 获取传感器上的大气压力值; Obtain the atmospheric pressure value on the sensor
    pressure = sense.get_pressure()
    # 加速度; Acceleration
    acc = sense.get_accelerometer_raw()

    acc="{x} {y} {z}".format(**acc)

    acc=acc.split(' ')

    # dt = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')

    dt=time.time()
    # 终端打印出温度值，保存小数点后两位; The terminal prints out the temperature value, saving two decimal places
    # print("Temperature: %0.2f C" % temp)

    # 参数scroll_speed修改的是滚动速度,默认0.1，text_colour是显示的字体颜色，back_colour是背景颜色; 
    # The parameter scroll_speed modifies the scrolling speed, default 0.1, text_colour is the displayed font color, back_colour is the background color
    # sense.show_message("temp=%0.2fC" % temp, scroll_speed=0.05,
    #                    text_colour=color_text, back_colour=color_back)
    db = pymysql.connect(
        host='localhost',
        port=3306,
        user='111111',
        password='1111111',
        db='111111',
        charset='utf8'
    )
    cursor = db.cursor()
    sql = "INSERT INTO data(temperature, \
           humidity, pressure, time, acc_x, acc_y, acc_z) \
           VALUES (%f, %f, %f, %s, %f, %f, %f)" % \
          (temp, humidity, pressure, dt, float(acc[0]), float(acc[1]), float(acc[2]))
    # cursor.execute(sql)
    # # 提交到数据库执行; Submit to database for execution
    # db.commit()
    try:
        # 执行sql语句; Execute sql statements
        cursor.execute(sql)
        # 提交到数据库执行; Submit to database for execution
        db.commit()
        print('success')
    except:
        # Rollback in case there is any error
        db.rollback()
        print('rollback')
    # 关闭数据库连接; Close the database connection
    db.close()

    time.sleep(10)
