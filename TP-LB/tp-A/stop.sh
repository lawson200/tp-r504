#!/bin/bash

# Noms des conteneurs à arrêter
CONTAINERS=("nginx1" "nginx2" "im-nginx-lb")

# Arrêter et supprimer chaque conteneur
for CONTAINER in "${CONTAINERS[@]}"; do
    # Arrêter le conteneur (ignorer les erreurs si le conteneur n'existe pas)
    docker stop "$CONTAINER" >/dev/null 2>&1

    # Supprimer le conteneur (ignorer les erreurs si le conteneur n'existe pas)
    docker rm "$CONTAINER" >/dev/null 2>&1
done

echo "Les conteneurs ont été arrêtés et supprimés."

