# Task Manager Application

A Spring Boot application for managing tasks with user authentication and role-based access control.

## Features

- User authentication and authorization
- Task management (create, read, update, delete)
- Role-based access control (Admin and User roles)
- Task assignment to users
- Task status tracking (completed/in progress)
- User profile management
- Responsive web interface

## Technical Stack

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **ORM**: Hibernate
- **Security**: Spring Security
- **Testing**: 
  - JUnit 5
  - Mockito
  - Testcontainers
  - Spring Test

## Project Structure

```
src/
├── main/
│   ├── java/pl/rengreen/taskmanager/
│   │   ├── model/           # Data models (Task, User, Role)
│   │   ├── repository/      # Data access layer
│   │   ├── service/         # Business logic layer
│   │   ├── controller/      # Web controllers
│   │   ├── configuration/   # Application configuration
│   │   └── dataloader/      # Data loading logic
│   └── resources/
│       ├── static/          # Static resources (CSS, JS)
│       └── templates/       # Thymeleaf templates
└── test/
    └── java/pl/rengreen/taskmanager/
        ├── service/         # Service layer tests
        └── controller/      # Controller tests
```

## Prerequisites

- Java 8 or higher
- Maven
- MySQL 8.0
- Docker (for running tests with Testcontainers)

## Setup and Installation

1. Clone the repository:
```bash
git clone [repository-url]
cd task-manager
```

2. Configure the database:
   - Create a MySQL database
   - Update `application.properties` with your database credentials

3. Build the project:
```bash
./mvnw clean install
```

4. Run the application:
```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`

## Testing

The project includes several types of tests:

1. Unit Tests:
```bash
./mvnw test
```

2. Integration Tests:
```bash
./mvnw verify
```

## API Endpoints

### Task Management
- `GET /tasks` - List all tasks
- `POST /tasks` - Create a new task
- `GET /tasks/{id}` - Get task by ID
- `PUT /tasks/{id}` - Update task
- `DELETE /tasks/{id}` - Delete task

### User Management
- `GET /users` - List all users (Admin only)
- `POST /register` - Register new user
- `GET /login` - Login page
- `GET /profile` - User profile

## Security

The application implements Spring Security with:
- User authentication
- Role-based authorization
- Password encryption
- Session management

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 