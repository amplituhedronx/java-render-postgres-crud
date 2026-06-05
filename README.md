# Java Spring Boot CRUD on Render Postgres

Clean Java implementation of a simple CRUD service using Spring Boot + Render Postgres.

## Tech Stack
- Java 21
- Spring Boot 3.3
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger UI)

## Access Swagger UI

After starting the application:

```
http://localhost:8080/swagger-ui.html
```

On Render:
```
https://your-app.onrender.com/swagger-ui.html
```

## Endpoints

| Method | Endpoint          | Description             |
|--------|-------------------|-------------------------|
| POST   | /records          | Create a new record     |
| GET    | /records          | Get all records         |
| GET    | /records/{id}     | Get single record       |

## Environment Variables (Render)

- `DATABASE_URL` — Internal connection string from Render Postgres

## Local Run

```bash
./mvnw spring-boot:run
```