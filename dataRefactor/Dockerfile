FROM openjdk:17-jdk-slim AS builder

WORKDIR /app

COPY target/*.jar app.jar

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/app.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]
