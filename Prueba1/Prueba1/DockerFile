# 1. Imagen base para compilar con Maven y Java 17
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# 2. Imagen base ligera para ejecutar la app
FROM eclipse-temurin:17

WORKDIR /app

COPY --from=build /app/target/httpdemo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]