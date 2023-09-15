# HNG-Task-Two

This API allows you to perform CRUD (Create, Read, Update, Delete) operations on Person's Object.

## Prerequisites

Java 8, Spring 6, Spring Boot 3 & h2 database

## Dependencies

- Spring Web
- Spring Data Jpa
- h2 Database
- Project Lombok
- Spring Validation

## Installation [pom.xml](pom.xml)

Install my-project with npm

1. Clone the repository to your local machine
2. git clone https://github.com/moseshunsu/hngx-stage-two
3. Run `mvn clean install` to build project.
4. Configure the application

The configuration for this API is stored in the `application.properties` file. To configure the API or make changes to its behavior, you can edit this file.

Example `application.properties`:

## Database configuration

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

5. To access your database, go to your browser then enter this link [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Endpoints

### Create a User

- **Endpoint**: `POST`
- **Description**: Create a new user with a name and a value and email and value.
- **Request Body**

```json
{
  "name": "John Cena",
  "email": "cena@gmail.com"
}
```

- **Response**:

```json
{
  "id": 1,
  "name": "John Cena",
  "email": "cena@gmail.com"
}
```

### Get a Person by ID

- **Endpoint**: GET /{user_id}
- **Description**: Retrieve a user by their ID.
- **Response**:

```json
{
  "id": 1,
  "name": "John Cena",
  "email": "cena@gmail.com"
}
```

### Update a Person by ID

- **Endpoint**: PUT /{user_id}
- **Description**: Update a user's name and value by their ID.
- **Request Body**:

```json
{
  "name": "John Paul",
  "email": "paul@email.com"
}
```

- **Response**

### Delete a Person by ID

- **Endpoint**: DELETE /{user_id}
- **Description**: Delete a user by their ID.
- **Response**:

```json
{
  "message": "User with Id: (user id no) deleted"
}
```

### Error Handling

- If the provided ID does not exist, you will receive a 404 Not Found response.
- If the provided email already exists, you will receive a "email already exists" response.
- If the provided name is not a string, you will receive a "name must be a string" response.
- If the provided email is not a string and in the wrong format, you will receive an "email must be a string" response.
- If the request body does not contain valid name and value fields, you will receive a 400 Bad Request response.
- If there is an internal server error, you will receive a 500 Internal Server Error response.
