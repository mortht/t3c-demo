#!/usr/bin/env bash
#set -x

docker-machine ls

echo "Creating docker machines as VirtualBox VMs ..."
docker-machine create -d virtualbox swarm-manager-1
docker-machine create -d virtualbox swarm-manager-2
docker-machine create -d virtualbox swarm-manager-3
docker-machine create -d virtualbox swarm-worker-1
docker-machine create -d virtualbox swarm-worker-2
docker-machine create -d virtualbox swarm-worker-3
docker-machine ls

echo "All machines created. Now setting up the docker swarm ..."
export MANAGER_HOST=$(docker-machine ip swarm-manager-1)
eval $(docker-machine env swarm-manager-1)
docker swarm init --advertise-addr ${MANAGER_HOST} --availability drain
export MANAGER_TOKEN=$(docker swarm join-token manager -q)
export WORKER_TOKEN=$(docker swarm join-token worker -q)
eval $(docker-machine env swarm-manager-2)
docker swarm join --token ${MANAGER_TOKEN} ${MANAGER_HOST}:2377
eval $(docker-machine env swarm-manager-3)
docker swarm join --token ${MANAGER_TOKEN} ${MANAGER_HOST}:2377
eval $(docker-machine env swarm-worker-1)
docker swarm join --token ${WORKER_TOKEN} ${MANAGER_HOST}:2377
eval $(docker-machine env swarm-worker-2)
docker swarm join --token ${WORKER_TOKEN} ${MANAGER_HOST}:2377
eval $(docker-machine env swarm-worker-3)
docker swarm join --token ${WORKER_TOKEN} ${MANAGER_HOST}:2377

echo "Docker swarm setup"
eval $(docker-machine env swarm-manager-1)
docker node ls
