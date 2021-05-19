# IoT based Bridge Health Monitoring (BHM)

This is a prototype for IoT based Bridge Health Monitoring (BHM)

Project codes for cits5551_IoT 2021

## BHM Data collecting
This work is based on the raspberry 4b. The software of the subsystem consists of sensor data collection and data uploading.

To run the program navigate to the pi-collectdata folder, run the collect_data.py, assuming that all dependencies have been installed. 

```bash
# Run collect_data on Linux/macOS
python3 collect_data.py
```
The program will constantly collect data from sensors and upload them to the online mysql.

## HBM Backend
This consists of a Java webserver using the Springboot  framework. This is the webserver used by the project, as well as the server handling a basic API.

```bash
# Run HBMbackend on Linux/macOS
java -jar idea-sharing-0.0.1-SNAPSHOT.jar
```
The frontend web page can request data to the webserver.
