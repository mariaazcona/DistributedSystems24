# BACKEND_APP

Laboratory for Distributed Systems - by Maria Azcona

Backend Technologies used for this project:
- **Micronaut Framework**
- **Gradle**
- **Docker**
- **Kubernetes/Minikube**
- **OpenAPI**

## HOW TO RUN

### Step 1: Execute project

```
./gradlew clean shadowJar
./gradlew run
```

Application will we available in the link provided by the terminal.

### Step 2: Try endpoints

```
curl http://localhost:8080/users
curl -X GET http://localhost:8080/users

curl http://localhost:8080/users/{id}
curl -X GET http://localhost:8080/users/{id}

curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{"name": "User1", "email": "user.sample@example.com"}'
```

### Step 3: Deploy to Kubernetes  #still unfinished

Files can be found in the k8s/ folder. They include configurations for deployment and service.
```
minikube start
kubectl get nodes #to check if minikube is working
kubectl apply -f kubernetes/deployment.yml
kubectl apply -f kubernetes/service.yml
```
Access the Application through the exposed service.
```
minikube service backend-lab
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
