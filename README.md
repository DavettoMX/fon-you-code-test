# Fonyou Code Test

This is a code test for the Backend Developer position at Fonyou. 

The code test is a REST API built with Java using the SpringBoot Framework. To the gestion
an multi-question survey.

- The survey can be assign to an student, or various students.
- The survey can have one or more questions.
- Each question have 4 options, and only one can be selected.
- There is only one correct answer per question.
- The sum of the value of each question is the score of the survey (100%).
- We can see the score of each student or all the students.

This API was built using the following technologies:

- Java 17.0.8
- Spring Boot 3.1.4
- Maven 3.9.4
- PostgreSQL 16.

## Installation

Use the package manager [maven](https://maven.apache.org/) to install the project.

```bash
mvn clean install
```

## Usage

To run the project you can use the following command:

```bash
mvn spring-boot:run
```

## Database Configuration

```
-- Database: fonyou_db

-- DROP DATABASE IF EXISTS fonyou_db;

CREATE DATABASE fonyou_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
```

All the tables are created automatically by the SpringBoot Framework because
it is configured to use the Hibernate ORM.

## API Testing

For test the API you can use the test cases in

```
src/test/java/com/example/fonyou_test_code
```

Here you can find all the `.http` files to create the API calls,
as well, you always can copy the JSON calls and use Postman to test the API.

As well you can find the file:

```
src/test/java/com/example/fonyou_test_code/FonyouTestCodeApplicationTests.java
```

That contains test cases for the API.

To run the test cases you can use the following command:

```bash
mvn test
```

Feel free to add more test cases if you want.

***The test cases are just think for the main purpouse of the API and cannot cover
all posible cases.***