# Use lightweight Java runtime
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy jar file into container
COPY target/*.jar app.jar

# Expose app port
EXPOSE 8087

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]