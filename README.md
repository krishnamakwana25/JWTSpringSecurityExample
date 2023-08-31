# JWTSpringSecurityExample
**Technology Stack used: Java, Springboot 3.1.3, MySql 8.1.0, Maven, Docker**

To Run This JWT Springboot Project, You can either extract the project from ZIP or You can use Below github link to clone project and use below command to run and test

1. git clone git@github.com:krishnamakwana25/JWTSpringSecurityExample.git
2. cd JWTSpringSecurityExample
3. Import the project as existing maven project in any IDE like(Eclipse or IntelliJ).
4. IMPORTANT STEP : Run this maven build command -> mvn clean install -U -X -DskipTests
5. In the step Assuming that your machine is having docker and docker compose is installed on the machine if not follow below link to install docker https://docs.docker.com/desktop/install/windows-install/.
6. To Run Rest Application on docker run below command
    docker-compose up
    or
    docker-compose up -d
7.  This command will start and run the application on port 8081
8.  Note: If on your machine 8081 and 3306 port is already used then change the port to any other port in below files Dockerfile, ,docker-compose file ,application.yml file



**To Test the REST API you can use POSTMAN tool**
______________________________________________________________________________
**To register the User - through POST http method**
1. POST API - To Register The User
2. Select POST http method from postman
3. Write this url:- http://localhost:8081/auth/createuser
4. Click on body tab and select Row then json
   - where we need to pass data in below form
    {
    "name":"xyz",
    "email":"xyz@gmail.com",
    "password":"123",
    "about":"Hello,I have register here..!"
}
5. Now you can hit the send button to register the user.

**To Get the JWT Token from rest API - through POST http method**
1. Select POST http method from postman
2. Write this url http://localhost:8081/auth/login
3. Click on body tab and from there select raw then use json format
4. You can pass json in raw {
    "email":"xyz@gmail.com",
    "password":"123"
}
5. Now you can hit the send button to get JWT Token 

**To Get the All Registered user - through GET http method**
1. Select GET http method from postman
2. write this url http://localhost:8081/home/user
3. Need to pass JWT TOKEN in Headers with Authorization key 
    for ex:- Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaHVtaWthbWFrd2FuYUBnbWFpbC5jb20iLCJpYXQiOjE2OTM0NjIyMDksImV4cCI6MTY5MzQ4MDIwOX0.x3Gf7sa_bjEGNl0jfQPryuflgWhsKr2VdD07Pa43yg20SpEbvyQIrRoSzRV1jcg0YuAsAXORti9B-wipKsFkjA
4. Now you can hit the send button to get All registered users list

**To run the project without docker locally below steps you can follow :**

1. Import the project into Any IDE.
2. Assuming to have MySQL database on local machine.
3. You have to create a dbjwt database with this query create database dbjwt;
4. To run the project locally need to change the application.yml configuration to this url: jdbc:mysql://localhost:3307/dbjwt
5. Now you can build the project with mvn clean install command .Run the main JwtExampleApplication.

