FROM maven:3.9.3-eclipse-temurin-17 AS build

# Copiar el pom.xml y los fuentes
COPY pom.xml .
COPY src ./src/

# Construir la aplicación
RUN mvn clean package

# Ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Copiar el JAR de la etapa de construcción
COPY --from=build target/springboot-testing-0.0.1-SNAPSHOT.jar /app/springboot-testing-0.0.1-SNAPSHOT.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app/springboot-testing-0.0.1-SNAPSHOT.jar"]
