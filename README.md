🔗 URL Shortener - Scalable URL Shortening Service

A production-inspired URL Shortener built with Spring Boot that demonstrates backend engineering concepts such as Redis caching, Kafka event streaming, analytics, rate limiting, custom short URLs, and URL expiration.

This project is designed to go beyond CRUD and showcase how real-world backend services are built.

🚀 Features
🔗 Generate short URLs
✨ Custom short codes
⏳ URL expiration support
⚡ Redis caching for fast lookups
📊 Click analytics
📨 Kafka event publishing & consumption
🛡️ Rate limiting
🗄️ PostgreSQL persistence
🐳 Docker support for Redis & Kafka
🛠️ Tech Stack
Technology	Purpose
Java 21	Programming Language
Spring Boot	Backend Framework
Spring Web	REST APIs
Spring Data JPA	Database Access
PostgreSQL	Persistent Storage
Redis	Cache Layer
Apache Kafka	Event Streaming
Docker	Containerization
Maven	Dependency Management
Lombok	Boilerplate Reduction
🏗️ Architecture
                        Client
                           │
                           ▼
                   Spring Boot API
                           │
          ┌────────────────┴────────────────┐
          │                                 │
          ▼                                 ▼
      Redis Cache                    PostgreSQL
   (Fast Read Layer)             (Persistent Storage)
          │                                 ▲
          └──────────────┬──────────────────┘
                         │
                         ▼
                  Kafka Producer
                         │
                  url-click-events
                         │
                         ▼
                  Kafka Consumer
                         │
                         ▼
                 Click Analytics
⚙️ How It Works
Creating a Short URL
User submits an original URL.
Optionally provides a custom short code.
Application validates the request.
URL is stored in PostgreSQL.
Short URL is returned.
Redirecting
User visits the short URL.
Application first checks Redis.
If found → Redirect immediately.
If not found:
Read from PostgreSQL
Store in Redis
Publish Kafka event
Redirect user
Analytics

Whenever a short URL is accessed:

Kafka publishes a click event
Consumer receives the event
Click information is stored
Analytics can be generated later
📂 Project Structure
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── producer
 ├── consumer
 ├── config
 ├── exception
 └── analytics
📡 API Endpoints
Method	Endpoint	Description
POST	/shorten	Create short URL
GET	/{code}	Redirect to original URL
GET	/analytics/{code}	View click analytics
📨 Sample Request
POST /shorten
{
  "originalUrl": "https://www.youtube.com",
  "customCode": "youtube",
  "expiresAt": "2026-12-31T23:59:59"
}
Response
{
  "shortCode": "youtube",
  "shortUrl": "http://localhost:8080/youtube"
}
📊 Implemented Features
✅ URL Shortening
✅ Custom Short URLs
✅ URL Expiration
✅ PostgreSQL Integration
✅ Redis Caching
✅ Kafka Producer
✅ Kafka Consumer
✅ Click Analytics
✅ Rate Limiting
✅ Docker Setup
🚧 Planned Improvements
Global Exception Handling
Swagger / OpenAPI Documentation
Scheduled Cleanup of Expired URLs
Docker Compose
Prometheus & Grafana Monitoring
JWT Authentication
User Accounts
Deploy on Cloud (AWS / Railway / Render)
Separate Analytics Microservice
💡 Backend Concepts Demonstrated
RESTful API Design
Layered Architecture
Caching Strategies (Redis)
Event-Driven Architecture (Kafka)
Database Persistence
Request Validation
Rate Limiting
DTO Pattern
Builder Pattern
Custom Exceptions
Docker-based Development
▶️ Getting Started
Clone the repository
git clone https://github.com/<your-username>/url-shortener.git
cd url-shortener
Start PostgreSQL, Redis and Kafka

Ensure PostgreSQL is running locally and start Redis and Kafka using Docker.

Run the application
mvn spring-boot:run

The application will be available at:

http://localhost:8080
📄 License

This project is built for learning, backend practice, and demonstrating scalable system design concepts. Feel free to fork it, explore it, and build upon it.
