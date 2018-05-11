#!/usr/bin/env bash

docker network create -d overlay --attachable t3cnet

docker volume create course-db-data

docker service create --name employee-service \
    --network t3cnet --hostname employee-service \
    mortht/t3c-employee-service:latest

docker service create --name course-db \
    --network t3cnet --hostname course-db \
    --mount type=volume,source=course-db-data,destination=/var/lib/mysql \
    --env MYSQL_ROOT_PASSWORD="t3c-demo" \
    --env MYSQL_DATABASE="t3c-demo" \
    --env MYSQL_USER="t3c-demo" \
    --env MYSQL_PASSWORD="t3c-demo" \
    mysql:latest

docker service create --name course-directory \
    --network t3cnet --hostname course-directory \
    --env SPRING_DATASOURCE_URL="jdbc:mysql://course-db:3306/t3c-demo" \
    --env SPRING_DATASOURCE_USERNAME="t3c-demo" \
    --env SPRING_DATASOURCE_PASSWORD="t3c-demo" \
    --env T3C_DEMO_EMPLOYEE_SERVICE_URL="http://employee-service:8080/employee" \
    --publish published=8080,target=8080 \
    --replicas 3 \
    mortht/t3c-course-directory:latest

docker service ls