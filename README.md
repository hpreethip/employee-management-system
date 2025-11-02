# Employee Management System

A Spring Boot REST API application for managing employees, their skills, contract types, shifts, and salary calculations.

## Overview

The Employee Management System is a comprehensive human resources management platform designed to streamline workforce administration. It provides complete lifecycle management for employees, including skill tracking, contract management, shift scheduling, and automated salary calculations.

## Key Features

- **Employee Management**: Create and retrieve employee information with full lifecycle tracking
- **Skill Management**: Assign and manage employee skills with rate-based pricing
- **Contract Type Management**: Define and manage different contract types with associated rates
- **Shift Management**: Add shifts to employees with duration and break tracking
- **Intelligent Salary Calculation**: Automated salary computation combining contract type rates and skill-based pay
- **Pagination Support**: Efficient paginated retrieval of employee records
- **Global Exception Handling**: Comprehensive error handling with appropriate HTTP status codes and error messages
- **API Documentation**: Interactive Swagger/OpenAPI documentation for all endpoints

## System Architecture

The application follows a layered architecture with clear separation of concerns:

- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic and orchestration
- **Repository Layer**: Manages data persistence using Spring Data JPA
- **Entity Layer**: Domain models representing database entities
- **DTO Layer**: Data Transfer Objects for API communication
- **Config Layer**: Application configuration including database, JSON serialization, and API documentation
- **Exception Layer**: Centralized error handling and response formatting

## Data Model

The system manages four core entities:

1. **Employee**: Core employee information with contract type and shift assignments
2. **Skill**: Skill definitions with rate-based pricing
3. **ContractType**: Employment contract types with base rates
4. **Shift**: Work shifts with duration, break time, and skill associations

## Salary Calculation Logic

The salary calculation is performed using a two-component model:

1. **Contract Type Pay**: Base pay calculated from total worked hours multiplied by the contract type rate
2. **Skill-Based Pay**: Additional compensation from hours worked per skill multiplied by the skill rate

The final salary is the sum of contract type pay and skill-based pay, providing a comprehensive compensation model that rewards both contract terms and skill application.

## Technologies

- **Java** 25
- **Spring Boot** 3.5.7
- **Spring Data JPA** for database operations
- **Spring Validation** for request validation
- **H2 Database** (in-memory)
- **Lombok** for reducing boilerplate code
- **Springdoc OpenAPI** (Swagger) for API documentation
- **Jackson** with JavaTimeModule for date/time serialization
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

## Accessing the Application

Once the application is running, you can access:

- **Base URL**: http://localhost:8081
- **Swagger UI**: http://localhost:8081/swagger-ui/index.html
- **API Documentation**: http://localhost:8081/api-docs

## H2 Database Console

Once the application is running, you can access the H2 console at:

- **URL**: http://localhost:8081/h2-console
- **JDBC URL**: `jdbc:h2:mem:serai`
- **Username**: `sa`
- **Password**: testdb
