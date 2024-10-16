# Geolocalizacion-Back
Backend to generate the geolocation project of IP addresses.

Prerequisites
There are a few things you'll need to have installed to get this up and running.

Java

JDK 11
Maven version 3.6.1

Running this application
To run this application from the command line with Maven:

mvn spring-boot:run

Or in an IDE, just run the Application class

Verify that the application is functioning as expected by checking: http://localhost:8080/

Overview

We have provided a few basic services for use in our e-commerce application:

InformationIpService - Class at the service layer where the logic is generated to obtain the IP information and to obtain the average consumption distance of the service.


REST Services

I currently offer two services:

- The first has the route: http://localhost:8080/operations-ips/get-information-ip. And it has as body a JSON type object with the following structure 
{
    “message": ”IP”
}, 

where IP is the IP to which you want to look up the information.

- The second one has the route http://localhost:8080/operations-ips/average-distance-countrys. It has no body to be consumed


