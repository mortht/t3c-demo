#!/usr/bin/env bash
docker network create --attachable appnet
docker volume create course-db-data

docker run -d --rm --name employee-service \
    --network appnet \
    mortht/t3c-employee-service:latest

docker run -d --rm --name course-db \
    --network appnet \
    -v course-db-data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD="t3c-demo" \
    -e MYSQL_DATABASE="t3c-demo" \
    -e MYSQL_USER="t3c-demo" \
    -e MYSQL_PASSWORD="t3c-demo" \
    mysql:latest

docker run -d --rm --name course-directory \
    --network appnet \
    -e SPRING_DATASOURCE_URL="jdbc:mysql://course-db:3306/t3c-demo" \
    -e SPRING_DATASOURCE_USERNAME="t3c-demo" \
    -e SPRING_DATASOURCE_PASSWORD="t3c-demo" \
    -e T3C_DEMO_EMPLOYEE_SERVICE_URL="http://employee-service:8080/employee" \
    -p 8080:8080 \
    mortht/t3c-course-directory:latest

docker ps