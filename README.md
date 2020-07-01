# Learning Play Front

_API for the Learning Play Project_

## About

Learning Play is a platform to create and evaluate test focused on the primary children

## Endpoints 

1. /users

    * GET - Returns all the registered users.

2. /users/id

    * GET - Returns a user matching a provided id.

3. /users/login

    * POST - Takes an Auth object and returns an User object matching Auth's credentials. 

4. /users/sign-up

    * POST - Takes an User objects and saves it in the database.

## Built With 🛠️

* [Java](https://www.oracle.com/java/technologies/)
* [Maven](https://maven.apache.org/) - Dependency Management
* [PostgreSQL](http://www.dropwizard.io/1.0.2/docs/) - Database
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - ORM
* [Spring Boot](https://spring.io/projects/spring-boot) - RESTful framework

## Authors ✒️

* **Development** - [dnieln7](https://github.com/dnieln7)