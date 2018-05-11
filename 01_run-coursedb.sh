#!/usr/bin/env bash

docker run --rm --name=coursedb \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=rootpw \
    -e MYSQL_DATABASE=coursedb \
    -e MYSQL_USER=appuser \
    -e MYSQL_PASSWORD=apppw \
    mysql:latest