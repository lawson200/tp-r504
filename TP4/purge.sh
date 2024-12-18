#!/bin/bash
docker rm -f $(docker ps -aq)
docker network prune -f
docker volume prune -f
# l'oiption sert 
#docker system prune -af --volumes 
