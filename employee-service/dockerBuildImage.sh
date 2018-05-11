#!/usr/bin/env bash
docker build -t mortht/t3c-employee-service:latest --build-arg JAR_FILE=employee-service.jar .