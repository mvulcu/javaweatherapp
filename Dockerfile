# Use the official OpenJDK image for the base layer
FROM openjdk:17-jdk-slim as build
# Set the working directory in the container
WORKDIR /app

# Copy the maven executable into the container
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Give execution rights on the mvnw
RUN chmod +x mvnw

# Build the application without running tests
RUN ./mvnw package -DskipTests

# Start with a clean slate
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy only the artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Instruct the port on which the container should listen for connections
EXPOSE 8080

# Define the command to run the app using the $PORT provided by Heroku
CMD ["java", "-jar", "app.jar", "--server.port=${PORT:8080}"]
