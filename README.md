# IoT based Bridge Health Monitoring (BHM)

This is a prototype for IoT based Bridge Health Monitoring (BHM)

Project codes for cits5551_IoT 2021

## BHM Data collecting
This work is based on the raspberry pi 4b. The software of the subsystem consists of sensor data collection and data uploading.

To run the program navigate to the pi-collectdata folder, run the collect_data.py, assuming that all dependencies have been installed. The commands to install necessary libraries is as follow:

```bash
sudo apt-get install sense_hat
pip3 install pymsql
```
The commands to collect data is as follow:
```bash
# Run collect_data on Linux/macOS
python3 collect_data.py
```
The program will constantly collect data from sensors and upload them to the online mysql.

## HBM Backend
This consists of a Java webserver using the Springboot  framework. This is the webserver used by the project, as well as the server handling a basic API. In the project, we deployed the application on AliCloud Elastic Compute Service (ECS).
To test the code, first generate table structure using the .sql file. Then run the following command:
```bash
# Run HBMbackend on Linux/macOS
java -jar idea-sharing-0.0.1-SNAPSHOT.jar
```
The server can respond to request from the frontend web page on port 8080. We provide a [swagger ui](http://120.78.146.114:8080/swagger-ui.html#) to briefly present the server APIs.
