#!/bin/bash
docker rm -f $(docker ps -aq)
docker network prune -f
docker volume prune -f
# l'option sert 
#docker system prune -af --volumes 
