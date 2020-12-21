# Springboot_REST API-CRUD-Angular-Pearson-Practical-Test

Video URL : https://youtu.be/rjdzD45GNRo

Name :- Nilan Meegoda
University :- SLIIT


The Program mainly contains some details of patients who were diagonized as covid-19 patients(fictional)
This repository contains source code for the program that I designed for the Pearson Practical Test for Platform Automation Internship. 
The backend is developed using Spring Boot framework &amp; H2 database while the front end was developed using Angular framework

First download the repo.

CoronaPatients_PearsonTest folder contains mainly two sections,

1) Frontend - developed using Angular (frontend-angualr folder)
2) Backend - developend using Spring Boot framework and H2 database

* First open the project folder with eclipse and dependencies that I have used in backend development are 

    spring-boot-starter-data-jpa
    spring-boot-starter-web
    spring-boot-starter-web-services
    javax.validation
    h2

* RUN the project as a Spring Boot Application
 
* base Url is http://127.0.0.1:8080/rest/v2
* You can use POSTMAN to test CRUD operations, pass the values as a raw JSON object

  1. http://127.0.0.1:8080/rest/v2/patients - GET
  2. http://127.0.0.1:8080/rest/v2/patients/{id} - GET,PUT & DELETE by patient id
  
* Now to check the frontend, open the frontend-angualr folder through VS-code or prefered IDE and 
first install missing dependancies then run the program using 

    ng serve command
    
* Since I have implemented " @CrossOrigin(origins = "http://localhost:4200") " in the Patient controller class
  You won't get any issues regarding ports since backend use 8080 while the frontend use 4200.
