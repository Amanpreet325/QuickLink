# 🔗 URL Shortener

A production-inspired URL Shortener built with **Spring Boot** that demonstrates scalable backend development using **Redis, Apache Kafka, PostgreSQL, Docker, and Spring Boot**.

This project goes beyond a basic CRUD application by implementing caching, event-driven architecture, analytics, rate limiting, custom short URLs, and URL expiration.

---

## 🚀 Features

- ✅ Generate short URLs
- ✅ Custom short codes
- ✅ URL expiration support
- ✅ Redis caching for ultra-fast lookups
- ✅ Kafka event publishing
- ✅ Click analytics
- ✅ Rate limiting
- ✅ PostgreSQL persistence
- ✅ Dockerized Redis & Kafka

---

## 🏗️ Architecture

```
                    Client
                       │
                       ▼
              Spring Boot REST API
                       │
        ┌──────────────┴──────────────┐
        │                             │
        ▼                             ▼
     Redis Cache                 PostgreSQL
  (Fast Read Layer)         (Persistent Storage)
        │                             ▲
        └──────────────┬──────────────┘
                       │
                       ▼
               Apache Kafka Producer
                       │
                url-click-events
                       │
                       ▼
               Apache Kafka Consumer
                       │
                       ▼
                Click Analytics
```

---

## 🛠 Tech Stack

| Technology | Usage |
|------------|-------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web | REST APIs |
| Spring Data JPA | ORM |
| PostgreSQL | Database |
| Redis | Caching |
| Apache Kafka | Event Streaming |
| Docker | Containerization |
| Maven | Build Tool |
| Lombok | Boilerplate Reduction |

---

## 📂 Project Structure

```
src
│
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
├── producer
├── consumer
└── analytics
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/shorten` | Create Short URL |
| GET | `/{code}` | Redirect to Original URL |
| GET | `/analytics/{code}` | Get Click Analytics |

---

## 📥 Sample Request

### Create Short URL

```http
POST /shorten
```

```json
{
    "originalUrl": "https://www.youtube.com",
    "customCode": "youtube",
    "expiresAt": "2026-12-31T23:59:59"
}
```

### Response

```json
{
    "shortCode": "youtube",
    "shortUrl": "http://localhost:8080/youtube"
}
```

---

## ⚡ Request Flow

### URL Creation

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Generate / Validate Short Code
   │
   ▼
Save to PostgreSQL
   │
   ▼
Return Short URL
```

---

### URL Redirection

```
Client
   │
   ▼
Controller
   │
   ▼
Check Redis Cache
   │
 ┌─┴─────────────┐
 │               │
Hit             Miss
 │               │
 ▼               ▼
Redirect     PostgreSQL
                 │
                 ▼
           Store in Redis
                 │
                 ▼
         Publish Kafka Event
                 │
                 ▼
              Redirect
```

---

## 📊 Analytics Flow

```
User Clicks URL
        │
        ▼
Kafka Producer
        │
        ▼
url-click-events
        │
        ▼
Kafka Consumer
        │
        ▼
Store Click Analytics
```

---

## ✨ Implemented Features

- URL Shortening
- Custom Short URLs
- URL Expiration
- Redis Cache
- Kafka Producer
- Kafka Consumer
- Click Analytics
- Rate Limiting
- PostgreSQL Integration
- Docker Integration

---

## 🚧 Upcoming Features

- Global Exception Handling
- Swagger / OpenAPI Documentation
- Scheduled Cleanup for Expired URLs
- Docker Compose
- Prometheus + Grafana Monitoring
- JWT Authentication
- User Accounts
- Cloud Deployment
- Analytics Microservice

---

## ▶️ Getting Started

### Clone the repository

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

### Start Dependencies

- PostgreSQL
- Redis
- Kafka

(or run them using Docker)

### Run the application

```bash
mvn spring-boot:run
```

Application starts on:

```
http://localhost:8080
```

---

## 💻 Backend Concepts Demonstrated

- Layered Architecture
- REST API Design
- DTO Pattern
- Builder Pattern
- Redis Caching
- Event-Driven Architecture
- Kafka Messaging
- Database Optimization
- Request Validation
- Rate Limiting
- Custom Exceptions
- Docker-based Development

---

## 👨‍💻 Author

**Amanpreet Singh**

Backend Developer | Java | Spring Boot | Microservices | Kafka | Redis | PostgreSQL

---

⭐ If you found this project useful, consider giving it a star!
