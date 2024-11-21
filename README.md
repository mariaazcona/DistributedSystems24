# BACKEND_APP

Laboratory for Distributed Systems - by Maria Azcona

This project uses Micronaut as the Backend Technology.
Programs used:
- **Java Development Kit (JDK) 17**.
- **Gradle 8.8**.
- **Git**.
- **Docker** and **Docker Compose**

## HOW TO RUN

### Step 1: Download or clone project

```
git clone https://github.com/mariaazcona/backend_app.git
```

### Step 2: Execute project

```
cd backend_app

./gradlew clean shadowJar
./gradlew run
```

Application will we available in http://localhost:8080.

### Step 3: Try endpoints

```
curl http://localhost:8080/users
curl http://localhost:8080/users/{id}
```

### Optional step: Execute with Docker instead

```
docker build -t backend_app .
docker run -p 8080:8080 backend_app
```

## DOCUMENTATION
Following the 12-Factor principle:
- configuration is handled in application.yml or environment variables
- compatible with local developement and containerized deployment
- Swagger API Documentation at endpoint /swagger
