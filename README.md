# BACKEND_APP

Laboratory for Distributed Systems - by Maria Azcona & Petros Mouchtaropoulos

Backend Technologies used for this project:
- **Micronaut Framework**
- **Gradle**
- **Docker**
- **Kubernetes/Minikube**
- **OpenAPI/Swagger**

## HOW TO RUN

### Step 1: Execute project in codespace

Java version must be upgraded to 17:
```
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```
Docker-compose build and up:
```
docker-compose up --build
```

Application will we available in the link provided by the terminal.

### Step 2: Try endpoints #still unfinished

```
curl http://localhost:8080/users
curl -X GET http://localhost:8080/users

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

## DOCUMENTATION
Following the 12-Factor principle:
- configuration is handled in application.yml or environment variables
- compatible with local developement and containerized deployment
- Swagger API Documentation at endpoint /swagger
