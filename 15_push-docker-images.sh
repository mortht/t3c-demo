#!/usr/bin/env bash
pushd course-directory
    ./dockerPushImage.sh
popd

pushd employee-service
    ./dockerPushImage.sh
popd