FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/backend_app-all.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
