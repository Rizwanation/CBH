# CBH Assignment


## Introduction

This is a Java Maven Selenium Automation Framework and it has the following features:
- **Parallel Exeuction of tests**
- **Automation Report Generation with test logs on execution completion**
- **Local Execution and Standalone Selenium Grid Execution**


## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

For local execution:
- **[Java 19](https://openjdk.java.net/projects/jdk/19/)** (as the core programming language)
- **[Maven 3.8.6](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

For execution in Standalone Selenium Grid, in addition to above dependencies you will also need:
- **[Docker Desktop](https://www.docker.com/products/docker-desktop/)** (For composing docker image)

> If your JAVA_HOME is set to anything other than JDK 19, you would need to update the path. Else your project
> might not run. Also, do remember to set the correct JDK settings in your IDE.

## Instructions for Execution
### Local Execution ###

By default, config file is already set for local execution, the easiest way to get started is to extract this project and open it from IntelliJ.
Once there, right-click testng.xml and click Run.

Alternatively, in terminal, go to project root directory and execute following command:
1. ```mvn test -PTest```

### Standalone Selenium Grid Execution ###

For execution in Standalone Selenium Grid:
1. Go to [Configs/config.properties](Configs/config.properties) 
2. Set mode=grid_standalone
3. In terminal, go to project root and execute following commands:

   1. ```docker-compose up -d``` 
   
   (Note: running this command for the first time will take a few minutes to set up the container from docker image)
   It will set up a Selenium Grid Hub and a Google Chrome node inside it. Once container is up, it can be viewed at http://localhost:4444/ui

   2. ```mvn test -PTest```

Note : To view execution inside container:
   1. Go to http://localhost:4444/ui#/sessions while test execution is in progress.
   2. In the sessions column, click on the camera icon
   3. Prompt will ask for password. Enter: secret
   4. Video can be viewed for test execution.


## Video of Test Execution ##

### Local Execution ###
https://drive.google.com/file/d/1yrTUJ1RXmICzOkwmo1ck4NrMm-JhSoz1/view?usp=share_link

### Remote Execution with Standalone Selenium Grid Hub ###
https://drive.google.com/file/d/16wEMqx5GPXOeaMJK2qMgBcCs1s6g6bNi/view?usp=share_link


 




