This is a student registration management system where a user register a student from browser and then view all registered students.
# Student Registration System

## Project Description
A simple web application built with Java and Spring Boot that allows users to register students and view all registered students.

## Technologies Used
- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- PostgreSQL
- JDBC
- Maven

## Features
- Register a new student.
- Enter first name, last name, email, and age.
- Store student information in PostgreSQL.
- View all registered students.
- Display a success message after registration.

## Database
Database name: `student_management`

Table name: `students`

The table contains:
- id
- full_name
- age
- email

## Project Structure
- `config` – Database connection configuration.
- `controller` – Handles web requests.
- `model` – Contains the Student class.
- `repository` – Handles database operations using JDBC.
- `service` – Contains application business logic.
- `templates` – Contains Thymeleaf HTML pages.

## How to Run
1. Clone or download the project.
2. Open it in IntelliJ IDEA.
3. Create the PostgreSQL database named `student_management`.
4. Create the `students` table.
5. Configure your PostgreSQL username and password in `DatabaseConfig.java`.
6. Run `StudentRegistrationApplication.java`.
7. Open your browser and visit:

`http://localhost:8080/student/register`

## Pages
- `/student/register` – Student registration page.
- `/student/all` – View all registered students.

## Author
Student Registration System Project
