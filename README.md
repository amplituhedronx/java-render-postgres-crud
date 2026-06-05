# Java Spring Boot CRUD on Render Postgres

Clean Java implementation of a simple CRUD service using Spring Boot + Render Postgres.

## Tech Stack
- Java 21
- Spring Boot 3.3
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger UI)

## Access Swagger UI

After deployment:
```
https://your-app.onrender.com/swagger-ui.html
```

## Endpoints

| Method | Endpoint          | Description             |
|--------|-------------------|-------------------------|
| POST   | /records          | Create a new record     |
| GET    | /records          | Get all records         |
| GET    | /records/{id}     | Get single record       |

## Deployment on Render (Recommended: Docker)

1. Create a new **Web Service** on Render
2. Connect this GitHub repository
3. Use these settings:

| Setting           | Value                                      |
|-------------------|--------------------------------------------|
| Environment       | `Docker`                                   |
| Build Command     | (leave empty when using Dockerfile)        |
| Start Command     | (leave empty when using Dockerfile)        |
| Dockerfile Path   | `./Dockerfile`                             |

4. Add Environment Variable:
   - `DATABASE_URL` = Your Internal Postgres URL

5. Deploy

## Local Development

```bash
./mvnw spring-boot:run
```

## Local Docker Build & Run

```bash
docker build -t java-crud-api .
docker run -p 8080:8080 -e DATABASE_URL="your-db-url" java-crud-api
```