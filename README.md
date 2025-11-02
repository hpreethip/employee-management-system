# Employee Management System

A Spring Boot REST API application for managing employees, their skills, contract types, shifts, and salary calculations.

## Technologies

- **Java** 25
- **Spring Boot** 3.5.7
- **Spring Data JPA** for database operations
- **H2 Database** (in-memory)
- **Lombok** for reducing boilerplate code
- **Maven** for dependency management

## Prerequisites

- Java 25 or higher
- Maven 3.6+

## Running the Application

1. Navigate to the project directory:

   ```bash
   cd employee-management-system
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on **http://localhost:8081**

## H2 Database Console

Once the application is running, you can access the H2 console at:

- **URL**: http://localhost:8081/h2-console
- **JDBC URL**: `jdbc:h2:mem:serai`
- **Username**: `sa`
- **Password**: testdb
