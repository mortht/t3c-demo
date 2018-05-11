#!/usr/bin/env bash

set -x

docker-machine ls

echo "Deleting docker machines VMs ..."
docker-machine rm swarm-manager-1 swarm-manager-2 swarm-manager-3 swarm-worker-1 swarm-worker-2 swarm-worker-3
docker-machine ls
