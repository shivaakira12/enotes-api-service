# E-Notes Project – Real-Time Application

## Project Overview

The **E-Notes Project** is a comprehensive real-time note-taking and to-do management application. It offers robust features for user authentication, notes management, and task organization, all built on a scalable tech stack. The project is developed with both **Spring Boot** on the backend and **Angular/React** on the frontend. 

---

## Technology Stack

### Backend:
- **Spring Boot** (REST API, JPA, AOP, Security)
- **OAuth Login** (Google/Facebook)
- **Caching** (To optimize database queries)
- **Junit & Mockito** (Unit Testing)
- **SonarQube** (Code Quality)
- **JMeter** (Performance Testing)
- **Swagger** (API Documentation)
- **Actuator** (Monitoring)
- **Scheduler** (For scheduled tasks)
- **Logging** (Detailed logging for API events)
- **Docker** (Containerization)
- **GitHub** (Version Control)

### Frontend:
- **Angular/React** (SPA framework for dynamic UI)

### Database:
- **MySQL** (Relational Database)

### Tools:
- **GitHub** (Code Repository)
- **STS** (Spring Tool Suite)
- **Figma** (UI Design)

### Deployment:
- **AWS** (Amazon Web Services for cloud deployment)

---

## Core Functionality & Features

### 1. **User Authentication and Authorization**
- **User Registration**: Supports email verification during the signup process.
- **User Login**: Secure JWT-based authentication.
- **Role-Based Access Control**: Different roles (Admin, User) with specific access permissions.

### 2. **Notes Management**
- **Category Management**: Create, update, and delete categories.
- **Notes CRUD**: Create, edit, and delete notes.
- **Attachments**: Attach files like PDFs and images to notes. Users can view or download these attachments.
- **Pagination**: Paginated view for notes for better performance.
- **Search**: Search notes by title, content, or category.
- **Favorites**: Mark notes as favorites and view a list of favorite notes.
- **Copy Notes**: Duplicate notes easily.
- **Export**: Export notes in Excel or PDF formats.

### 3. **Todo Management**
- **Task Management**: Create, edit, and delete tasks.
- **Priority Levels**: Assign priority to tasks (Low, Medium, High).
- **Task Status**: Set task statuses like "To-Do", "In Progress", or "Completed".
- **Reminders**: Set reminders via push notifications or email reminders.

---

## Database Setup

The following are the necessary SQL scripts to set up the database for the **E-Notes** project:

### 1. **Users Table**
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    mobile_no VARCHAR(15)
);

### 2. **Role Table**

CREATE TABLE role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
```

### 3. **User Role Table**
CREATE TABLE user_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
);
```

### 4. **Category Table**

CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by INT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

### 5. **Notes Table**

CREATE TABLE notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(1000) NOT NULL,
    description VARCHAR(1000),
    category_id INT,
    file_id INT NULL,
    created_by INT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


### 6. **File Details Table**

CREATE TABLE file_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    original_file_name VARCHAR(255) NOT NULL,
    display_file_name VARCHAR(255) NOT NULL,
    upload_file_name VARCHAR(255) NOT NULL,
    path VARCHAR(500) NOT NULL,
    file_size DOUBLE NOT NULL,
    file_type VARCHAR(100) NOT NULL
);

### 7. **Todo Table**
CREATE TABLE todo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    priority INT,
    status INT,
    created_by INT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

---

## Deployment and Source Control

The project is hosted on GitHub with multiple branches for development, testing, and production environments. You can clone or fork the project using the following repository URL:

- **GitHub Repository**: [E-Notes API Service](https://github.com/shivaakira12/enotes-api-service.git)

Branches include:
- `dev` (Development)
- `uat` (User Acceptance Testing)
- `prod` (Production)

---

## UI Design
UI/UX design was created using **Figma** for wireframes and mockups.

---

## Deployment

The application is deployed on **AWS**, utilizing various AWS services for scalability and reliability.

---

## Frontend Customization

Use the **Aptos** font family in your frontend for a clean and modern look. Example:


body {
    font-family: 'Aptos', sans-serif;
}


---

Thank you for using the E-Notes Project!

