# Use an official OpenJDK as a parent image
FROM openjdk:8-jre-alpine
#FROM openjdk:8-jre-slim
#FROM openjdk:9-jre-slim TODO build with Docker openjdk:9

MAINTAINER Thiemo Morth <thiemo.morth@gmail.com>

# Define an argument to be passed to the docker build
ARG JAR_FILE

# Copy the application contents into the container at /app
ADD target/${JAR_FILE} /app/app.jar

# Set the working directory to /app
WORKDIR /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run app.py when the container launches
CMD ["java", "-jar", "/app/app.jar"]