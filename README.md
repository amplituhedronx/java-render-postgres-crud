# Java Spring Boot CRUD on Render Postgres

Simple CRUD web service (add + retrieve records) built with:
- Java 21 + Spring Boot 3.3
- Spring Data JPA
- PostgreSQL
- Deployed on Render

## Local Development

```bash
./mvnw spring-boot:run
```

## Environment Variables (Render)

- `DATABASE_URL` - Internal Postgres connection string

## Endpoints

- `POST /records` - Create record
- `GET /records` - List all records
- `GET /records/{id}` - Get single record
