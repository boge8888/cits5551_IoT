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

## BHM Backend
This consists of a Java webserver using the Springboot  framework. This is the webserver used by the project, as well as the server handling a basic API. In the project, we deployed the application on AliCloud Elastic Compute Service (ECS).
To test the code, first generate table structure using the .sql file. Then run the following command:
```bash
# Run HBMbackend on Linux/macOS
java -jar idea-sharing-0.0.1-SNAPSHOT.jar
```
The server can respond to request from the frontend web page on port 8080. We provide a [swagger ui](http://120.78.146.114:8080/swagger-ui.html#) to briefly present the server APIs.

## BHM Frontend
This consists of a Vue front end project prototype, which includes a login page and a main page,some css format and javascript code. This demo shows the baisc functionas of our system. It provides basic page preview, Api accesing functions and data updating. It will be improved or even rebuilt in the future. For now, it is just a prototye for presentation.
To run the code, you need to download "VScode" and install "Live server" extension. Then edit the settings.json file of live sever to establish a proxy. Otherwise accessment to our backend API will be treated as cross domain access. This inconvenience will be fixed in the future.
What you need to include in settings.json is:

```
"liveServer.settings.proxy": {  
        //Proxy setting
        "enable": true, //Open proxy

        "baseUri": "/api", //Proxy's root，such as http://localhost:5500/api

        "proxyUri": "http://120.78.146.114:8080/data/gettendata" //our api for latest data

}
```
## Frontend Framework Comparison and Decision
This section analyse feasibility of popular front-end development frameworks (such as Bootstrap, Angular, React, and Vue). The following lists provide summaries for the features, advantages, and applicable scenarios of each framework.

### The Vue Framework
i.   The lightweight implementation makes applications easy for installation and deployment.
ii.  Support code reuse and module reuse.
iii. No need to render the entire DOM when update elements in pages.
iv.  Require less optimisation.
v.   Code libraries change less frequently.

### The Bootstrap Framework
i.   Support multi-device platforms.
ii.  Responsive layout
iii. Modularised CSS files.
iv.  Provide built-in JavaScript plugins and abundant components.

### The Angular Framework
i.   Smooth bidirectional data binding.
ii.  Provides an efficient components set, thus simplifying the process of writing, changing and using.
iii. The precompiler feature helps applications loading faster.
iv.  MVC model allows view separation.

### The React Framework
i.   Modularised structure enables flexible code format.
ii.  Helpful for high-performance implementation of complex applications.
iii. Using React front-end development can be easier to maintain codes.
iv.  Support native mobile applications for Android and iOS platforms.

All frameworks have outstanding advantages and irreplaceable features for different applications. Considering the learning cost, Vue is the cheapest framework. It only requires basic JavaScript knowledge to participate in building the project. In addition, Vue provides abundant interfaces, plugins and code libraries, which are helpful to facilitate the prototyping of the system. Moreover, the lightweight implementation makes it easy to deploy Vue-based applications. Finally, our project life cycle will last the whole year, modules of Vue are rarely updated, which could be helpful to avoid unnecessary trouble. In summary, we decided to utilise the Vue framework to build our website.
