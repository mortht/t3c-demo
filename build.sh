#!/usr/bin/env bash
pushd course-directory
./build.sh
popd

pushd employee-service
./build.sh
popd