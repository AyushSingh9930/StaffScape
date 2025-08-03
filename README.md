# StaffScape

A simple Spring Boot application demonstrating an Employee Management System with in-memory user authentication and role-based access control.

## Features

* **In-memory Authentication**: Two roles defined—`USER` and `ADMIN`.
* **Role-based Authorization**:

  * Both roles can **view** employee data (GET endpoints).
  * Only `ADMIN` can **create**, **update**, or **delete** employees (POST, PUT, DELETE endpoints).
* **CRUD Operations** on Employee entities:

  * Create a new employee
  * Retrieve all employees or by ID
  * Update an existing employee
  * Delete an employee

## Technologies

* Java 17+ (or compatible)
* Spring Boot 3.x
* Spring Web (REST)
* Spring Security
* Maven

## Prerequisites

* Java JDK 17 or higher installed
* Maven 3.6+ installed

## Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/AyushSingh9930/employ-management-system.git
   cd employ-management-system/ems-api
   ```

2. **Build the project**

   ```bash
   mvn clean package
   ```

3. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

## Authentication & Authorization

The application uses HTTP Basic authentication with two in-memory users:

| Username | Password   | Role    |
| -------- | ---------- | ------- |
| `user`   | `password` | `USER`  |
| `admin`  | `password` | `ADMIN` |

* **USER** can access:

  * `GET /api/employees`
  * `GET /api/employees/{id}`
* **ADMIN** can access all endpoints:

  * `POST /api/employees`
  * `PUT /api/employees/{id}`
  * `DELETE /api/employees/{id}`

## REST API Endpoints

Base URL: `http://localhost:8080/api/employees`

| HTTP Method | Endpoint | Description                 | Roles Allowed |
| ----------- | -------- | --------------------------- | ------------- |
| GET         | `/`      | Get all employees           | USER, ADMIN   |
| GET         | `/{id}`  | Get employee by ID          | USER, ADMIN   |
| POST        | `/`      | Create a new employee       | ADMIN         |
| PUT         | `/{id}`  | Update an existing employee | ADMIN         |
| DELETE      | `/{id}`  | Delete an employee          | ADMIN         |

### Sample Requests

* **Get all employees (as USER)**

  ```bash
  curl -u user:password http://localhost:8080/api/employees
  ```

* **Create a new employee (as ADMIN)**

  ```bash
  curl -u admin:password \
       -H "Content-Type: application/json" \
       -d '{ "firstName": "John", "lastName": "Doe", "email": "john.doe@example.com" }' \
       -X POST http://localhost:8080/api/employees
  ```

* **Update an employee (as ADMIN)**

  ```bash
  curl -u admin:password \
       -H "Content-Type: application/json" \
       -d '{ "firstName": "Jane", "lastName": "Doe", "email": "jane.doe@example.com" }' \
       -X PUT http://localhost:8080/api/employees/1
  ```

* **Delete an employee (as ADMIN)**

  ```bash
  curl -u admin:password -X DELETE http://localhost:8080/api/employees/1
  ```

## Configuration

The security configuration can be found in `com.ems_api.config.SecurityConfig` where in-memory users and access rules are defined.

## License

This project is released under the MIT License. Feel free to use and modify as needed.

## Author

Ayush Singh – [GitHub Profile](https://github.com/AyushSingh9930)
