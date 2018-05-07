#!/usr/bin/env bash
docker run --rm -it \
    -v "$(pwd)":/project -w /project \
    -v maven-repo:/root/.m2 \
    maven:3.5-jdk-8 mvn clean install

docker build -t mortht/t3c-course-directory:latest --build-arg JAR_FILE=course-directory.jar .
