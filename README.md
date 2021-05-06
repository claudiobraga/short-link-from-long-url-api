Short Link Cláudio Braga Application

Web Application to create a URL Shortening service


Getting Started


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes, or thru the web, because the application was deployed in the HEROKU Cloud.


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


How to Run the Short Link Cláudio Braga Application


Start as a Spring Boot Application


Running and see functionalities Working


Postman / Internet browser (GET, POST)


https://desolate-tor-11653.herokuapp.com/urls


https://desolate-tor-11653.herokuapp.com/urls/description?description=git


https://desolate-tor-11653.herokuapp.com/urls/customalias?customAlias=FLnDec


Sample JSON on Postman with POST method:


https://desolate-tor-11653.herokuapp.com/urls


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



OBS: the value in customAlias is the Short Link ("customAlias": "FLnDec") in this case the short link is FLnDec
that will redirect to the original Link that is https://github.com/orgs/claudiobraga/dashboard.


To see the redirect working outside of Postman, is need to past the short link in the browser as follow below:

https://desolate-tor-11653.herokuapp.com/urls/customalias?customAlias=FLnDec



To run the application locally:
http://localhost:8080/urls


Built With


Spring Framework


Maven - Dependency Management


JavaSE-11


Author
Cláudio Braga
