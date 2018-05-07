#!/usr/bin/env bash
docker run --rm -it \
    -v "$(pwd)":/project -w /project \
    -v maven-repo:/root/.m2 \
    maven:3.5-jdk-9 mvn clean install

docker build -t mortht/t3c-employee-service:latest --build-arg JAR_FILE=employee-service.jar .
