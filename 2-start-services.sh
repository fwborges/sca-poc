#/bin/bash

docker-compose up -d config-server
sleep 10
docker-compose up -d employee-api