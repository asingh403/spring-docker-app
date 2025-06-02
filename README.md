# Spring Boot User Management API

[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-asingh4305%2Fspring--boot--user--api-blue)](https://hub.docker.com/r/asingh4305/spring-boot-user-api)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)](https://spring.io/projects/spring-boot)

A Spring Boot REST API for user management with complete CRUD operations, built with modern enterprise architecture patterns and deployed as a Docker container.

## 🚀 Quick Start

### Run with Docker (Recommended)
```bash
# Pull and run the latest version
docker run -p 8080:8080 asingh4305/spring-boot-user-api:latest

# The API will be available at http://localhost:8080
```

### Run from Source
```bash
# Clone the repository
git clone https://github.com/asingh403/spring-docker-app.git
cd spring-docker-app

# Run with Maven
./mvnw spring-boot:run

# Or build and run JAR
./mvnw clean package
java -jar target/spring-docker-app-1.0.0.jar
```

## 📋 API Documentation

### Base URL
```
http://localhost:8080
```

### Health Check
```http
GET /actuator/health
```
**Response:**
```json
{
  "status": "UP",
  "components": {
    "db": {"status": "UP"},
    "diskSpace": {"status": "UP"},
    "ping": {"status": "UP"}
  }
}
```

---

## 👥 User Management Endpoints

### 1. Create User
```http
POST /api/users
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "department": "Engineering"
}
```

**Success Response (201 Created):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "department": "Engineering"
}
```

**Error Response (409 Conflict):**
```json
{
  "error": "Conflict",
  "message": "User with email john.doe@example.com already exists",
  "status": 409
}
```

### 2. Get All Users
```http
GET /api/users
```

**Success Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "department": "Engineering"
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "department": "Marketing"
  }
]
```

### 3. Get User by ID
```http
GET /api/users/{id}
```

**Example:**
```http
GET /api/users/1
```

**Success Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "department": "Engineering"
}
```

**Error Response (404 Not Found):**
```json
{
  "timestamp": "2025-06-02T12:00:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "path": "/api/users/999"
}
```

### 4. Get User by Email
```http
GET /api/users/email/{email}
```

**Example:**
```http
GET /api/users/email/john.doe@example.com
```

**Success Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "department": "Engineering"
}
```

### 5. Get Users by Department
```http
GET /api/users/department/{department}
```

**Example:**
```http
GET /api/users/department/Engineering
```

**Success Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "department": "Engineering"
  },
  {
    "id": 3,
    "name": "Bob Wilson",
    "email": "bob.wilson@example.com",
    "department": "Engineering"
  }
]
```

### 6. Search Users by Name
```http
GET /api/users/search?name={searchTerm}
```

**Example:**
```http
GET /api/users/search?name=John
```

**Success Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "department": "Engineering"
  }
]
```

### 7. Update User
```http
PUT /api/users/{id}
Content-Type: application/json
```

**Example:**
```http
PUT /api/users/1
```

**Request Body:**
```json
{
  "name": "John Smith",
  "email": "john.smith@example.com",
  "department": "Marketing"
}
```

**Success Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Smith",
  "email": "john.smith@example.com",
  "department": "Marketing"
}
```

**Error Response (404 Not Found):**
```json
{
  "timestamp": "2025-06-02T12:00:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "path": "/api/users/999"
}
```

### 8. Delete User
```http
DELETE /api/users/{id}
```

**Example:**
```http
DELETE /api/users/1
```

**Success Response (200 OK):**
```json
{
  "message": "User deleted successfully"
}
```

**Error Response (404 Not Found):**
```json
{
  "timestamp": "2025-06-02T12:00:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "path": "/api/users/999"
}
```

### 9. Get System Statistics
```http
GET /api/users/stats
```

**Success Response (200 OK):**
```json
{
  "totalUsers": 5
}
```

---

## 🧪 Testing the API

### Using cURL

**Create a user:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson",
    "email": "alice.johnson@example.com",
    "department": "HR"
  }'
```

**Get all users:**
```bash
curl http://localhost:8080/api/users
```

**Update a user:**
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson-Smith",
    "email": "alice.smith@example.com",
    "department": "Operations"
  }'
```

**Delete a user:**
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

### Using Postman

1. Import the following endpoints into Postman
2. Set `Content-Type: application/json` for POST/PUT requests
3. Use the request bodies provided above

### Interactive API Documentation

Once the application is running, visit:
```
http://localhost:8080/swagger-ui.html
```

---

## 🏗️ Architecture

### Technology Stack
- **Java 17** - Modern LTS Java version
- **Spring Boot 3.2.5** - Enterprise framework
- **Spring Data JPA** - Data persistence layer
- **H2 Database** - In-memory database for development
- **Maven** - Build automation and dependency management
- **Docker** - Containerization

### Project Structure
```
src/
├── main/
│   ├── java/com/sdet/demo/
│   │   ├── controller/         # REST API endpoints
│   │   ├── service/           # Business logic layer
│   │   ├── repository/        # Data access layer
│   │   ├── entity/           # JPA entities
│   │   └── SpringDockerApplication.java
│   └── resources/
│       └── application.yml    # Configuration
├── test/                      # Unit and integration tests
├── Dockerfile                 # Container configuration
└── pom.xml                   # Maven dependencies
```

### Architecture Layers
```
HTTP Request → Controller → Service → Repository → Database
     ↓              ↓           ↓          ↓          ↓
JSON Input → Validation → Business → Data Access → H2 DB
     ↓              ↓           ↓          ↓          ↓
JSON Response ← Serialization ← Logic ← JPA/Hibernate ← Table
```

---

## 🐳 Docker

### Build Docker Image
```bash
# Build from source
docker build -t spring-boot-user-api .

# Run locally built image
docker run -p 8080:8080 spring-boot-user-api
```

### Docker Compose (Optional)
```yaml
version: '3.8'
services:
  api:
    image: asingh4305/spring-boot-user-api:latest
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
```

---

## 🔧 Configuration

### Environment Variables
| Variable | Description | Default |
|----------|-------------|---------|
| `SERVER_PORT` | Application port | `8080` |
| `SPRING_PROFILES_ACTIVE` | Active Spring profile | `default` |

### Application Properties
```yaml
server:
  port: 8080

spring:
  application:
    name: spring-docker-demo
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password: password
  h2:
    console:
      enabled: true
      path: /h2-console
```

---

## 🚦 HTTP Status Codes

| Status Code | Description |
|-------------|-------------|
| `200 OK` | Request successful |
| `201 Created` | Resource created successfully |
| `404 Not Found` | Resource not found |
| `409 Conflict` | Resource already exists (duplicate email) |
| `400 Bad Request` | Invalid request data |
| `500 Internal Server Error` | Server error |

---

## 📊 Monitoring

### Health Check Endpoints
- `GET /actuator/health` - Application health status
- `GET /actuator/info` - Application information
- `GET /actuator/metrics` - Application metrics

### Database Console (Development)
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 🔗 Links

- **Docker Hub**: https://hub.docker.com/r/asingh4305/spring-boot-user-api
- **GitHub Repository**: https://github.com/asingh403/spring-docker-app
- **Spring Boot Documentation**: https://spring.io/projects/spring-boot
- **Docker Documentation**: https://docs.docker.com/

---

## 👨‍💻 Author

**Ashutosh Singh**
- GitHub: [@asingh403](https://github.com/asingh403)
- Email: asingh.it@hotmail.com

---

**Built with ❤️ using Spring Boot and Docker**
