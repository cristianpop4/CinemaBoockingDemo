# 🎬 Cinema Booking Online

A RESTful backend application for online cinema seat booking, built with **Spring Boot 3** as part of a learning course. The project covers core concepts like REST API design, JPA/Hibernate, Spring Security, and Swagger documentation.
 
---

## 📌 Features

- Browse movies and screenings
- Book, confirm, or cancel seats for a screening
- Conflict detection — prevents double-booking of the same seat
- Role-based access control (Admin / User)
- Auto-generated seats when a cinema room is created
- API documentation via Swagger UI
---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17+ | Language |
| Spring Boot 3 | Framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database access layer |
| PostgreSQL | Relational database |
| Swagger / OpenAPI | API documentation |
| Maven | Build tool |
| Lombok | Boilerplate reduction |
 
---

## 🔐 Security & Roles

Authentication is handled via **HTTP Basic Auth**.

| Role | Permissions |
|---|---|
| `ROLE_ADMIN` | Create/delete screenings, manage rooms and movies |
| `ROLE_USER` | View movies & screenings, create/confirm/cancel bookings |
| Anonymous | View movies and screenings |

Two default accounts are seeded on startup:

| Email | Password | Role |
|---|---|---|
| admin@gmail.com | admin123 | ADMIN |
| user@gmail.com | user123 | USER |
 
---

## 📡 API Endpoints

### Movies `/api/movies`
| Method | Path | Access |
|---|---|---|
| GET | `/api/movies` | Public |
| GET | `/api/movies/{id}` | Public |
| POST | `/api/movies` | Authenticated |
| PUT | `/api/movies/{id}` | Authenticated |
| DELETE | `/api/movies/{id}` | Authenticated |

### Screenings `/api/screenings`
| Method | Path | Access |
|---|---|---|
| GET | `/api/screenings` | Public |
| GET | `/api/screenings/id/{id}` | Public |
| GET | `/api/screenings/movie/{movieId}` | Public |
| GET | `/api/screenings/room/{roomId}` | Public |
| GET | `/api/screenings/period?start=&end=` | Public |
| POST | `/api/screenings` | Admin only |
| PUT | `/api/screenings/{id}` | Authenticated |
| DELETE | `/api/screenings/{id}` | Admin only |

### Bookings `/api/bookings`
| Method | Path | Description |
|---|---|---|
| POST | `/api/bookings` | Create a booking |
| PUT | `/api/bookings/confirmations/{id}` | Confirm a booking |
| PUT | `/api/bookings/cancellations/{id}` | Cancel a booking |
| GET | `/api/bookings/{id}` | Get booking by ID |

### Cinema Rooms `/api/cinemarooms`
| Method | Path | Description |
|---|---|---|
| POST | `/api/cinemarooms` | Create room + auto-generate seats |
| GET | `/api/cinemarooms` | List all rooms |
| GET | `/api/cinemarooms/{id}` | Get room by ID |

### Seats `/api/seats`
| Method | Path | Description |
|---|---|---|
| GET | `/api/seats/room/{id}` | Get all seats in a room |
| GET | `/api/seats/{id}` | Get seat by ID |

### Users `/api/users`
| Method | Path | Description |
|---|---|---|
| POST | `/api/users/register` | Register a new user |
| GET | `/api/users/me` | Get current logged-in user |
 
---

## 📋 Booking Status Flow

```
ONHOLD → CONFIRMED
ONHOLD → CANCELED
CONFIRMED → CANCELED
```

A booking starts as `ONHOLD` when created. Conflict detection prevents any two bookings with status `ONHOLD` or `CONFIRMED` from sharing the same seat for the same screening.
 
---

## 📖 API Documentation

Once the application is running, Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```
 
---

## 📚 About

This project was built as part of a **backend development learning course**, covering:

- REST API design with Spring Boot
- Entity relationships with JPA/Hibernate
- Security with Spring Security (Basic Auth + Role-based access)
- Custom JPQL queries
- DTO pattern (Request/Response separation)
- Lombok for cleaner code

