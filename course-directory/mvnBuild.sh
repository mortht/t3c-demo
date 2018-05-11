#!/usr/bin/env bash
docker run --rm -it \
    -v "$(pwd)":/project -w /project \
    -v maven-repo:/root/.m2 \
    -v /var/run/docker.sock:/var/run/docker.sock \
    maven:3.5-jdk-8 mvn $@