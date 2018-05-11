#!/usr/bin/env bash
pushd course-directory
    ./mvnBuild.sh clean install
popd

pushd employee-service
    ./mvnBuild.sh clean install
popd