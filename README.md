#Recipe Backend

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.recipesbackend.RecipesBackendApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running the application in Docker

Run following command

```shell
mvn spring-boot:build-image
```

**For this to work, we need to have Docker installed and running.**

Then to start the container, we can simply run:

```shell
docker run -it -p8080:8080 recipes-backend:0.0.1-SNAPSHOT
```