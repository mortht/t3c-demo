#!/usr/bin/env bash
pushd course-directory
    ./dockerBuildImage.sh
popd

pushd employee-service
    ./dockerBuildImage.sh
popd