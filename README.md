BAML Cláudio Braga Application

Web Application to create a URL Shortening service


Getting Started


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


Prerequisites

To install, run and see functionalities working in this project is necessary the following software:

JDK 11 or above

Maven

Spring

Eclipse

MySQL

Postman

Build

mvn clean install

How to Run the BAML Cláudio Braga Application

Start as a Spring Boot Application


Running and see functionalities Working

Postman / Internet browser (GET, POST)

http://localhost:8080/urls


http://localhost:8080/urls/description?description=dev


http://localhost:8080/urls/customalias?customAlias=UZaS8


Sample JSON on Postman with POST method

{
    "originalUrl": "https://github.com/orgs/claudiobraga/dashboard",
    "creationDate": "2021-04-27",
    "description": "gitHub"
}


Response Body with status 201 Created


{
    "originalUrl": "https://github.com/orgs/claudiobraga/dashboard",
    "customAlias": "FLnDec",
    "creationDate": "2021-04-27",
    "description": "gitHub",
    "id": 42
}



OBS: the value in customAlias is the Short Link ("customAlias": "FLnDec")in this case is FLnDec
that will redirect to the original Link that is https://github.com/orgs/claudiobraga/dashboard.
Also I did write the HTML in the controller(I know that this is not the best practice) was just to facilitate my understanding, because I was running out of time.

With more time I could create an index to put there the HTML to redirect to the original link.
Handler some constraint regarding to the Short Link.


Built With


Spring Framework


Maven - Dependency Management


JavaSE-11


Author
Cláudio Braga
