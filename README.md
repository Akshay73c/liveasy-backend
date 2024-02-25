# Liveasy-backend

## Overview
This assignment-short-project for [Liveasy](https://liveasy.net.in/) and demonstrates a Java Spring Boot backend application leveraging a PostgreSQL database.

## Technologies

- Java version 17
- Spring Boot 3.2.X
- Databse: PostgreSQL


## Features
- Add a payload
- Get a payloads by loadId or shipperId
- Update, Delete by loadId

**Project Structure**
- src/main/java: Contains the Spring Boot application code, including entities, repositories, controllers, and services.
- pom.xml: Defines project dependencies and configurations.
- application.properties: Defines application configuration, including database connection details.

## Setup and Running

**Prerequisites:**
- Java 17
- PostgreSQL database running locally

**Steps:**

1. Clone the repository:
   ```bash
   git clone <url>

2. Set up the backend:

- Update database credentials in src/main/resources/application.properties.
    - Replace `your_database_username` with your Postgres username.
    - Replace `your_database_password` with your Postgres password.
    - Edit `port` number as postgres server

- Build and run the backend:
  (Run the LiveasyBackendApplication.java.java file)
  ```bash
  ./mvnw spring-boot:run
(or equivalent command for your build system).

4. Run and test locally
- Use Postman or a similar API testing tool.
- Create a new request and choose the appropriate HTTP method (e.g., POST for your /load endpoint).
- Set the URL to http://localhost:8080/load (adjust port if different).
- In the request body, create JSON data with the required fields
  - example payload:    
    - {
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": 1,
    "weight": 100,
    "comment" : "xyz",
    "date" : "dd-mm-yyyy",
    "shipperId": "47223d58-1234-5678-9abc-def012345678" // Replace with valid UUID
    }
