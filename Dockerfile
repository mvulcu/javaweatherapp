# Use the official OpenJDK image for the base layer
FROM openjdk:17-jdk-slim as build
# Set the working directory in the container
WORKDIR /app

# Copy the maven executable into the container
COPY mvnw .
COPY .mvn .mvn

# Copy your pom.xml file and source code into the container
COPY pom.xml .
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Run the application on port 80
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar", "app.jar"]