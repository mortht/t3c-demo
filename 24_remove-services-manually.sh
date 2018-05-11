#!/usr/bin/env bash

docker service ls

docker service rm course-directory
docker service rm course-db
docker service rm employee-service
docker network rm t3cnet
#docker volume rm course-db-data

docker service ls