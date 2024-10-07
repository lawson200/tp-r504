#!/bin/bash

# URL de base
URL="http://localhost:83"

# Compteur de réponses attendues
EXPECTED_RESPONSE="Hello 1"
ALTERNATE_RESPONSE="Hello 2"

# Variable pour suivre le dernier serveur qui a répondu
last_response=""

for i in {1..500}; do
    # Effectuer un appel curl
    response=$(curl -s "$URL")
	if [[ $response == "Hello 1" ]]
	then
		((c+=1)) #incrémenter un compteur
	fi
done

echo "c=$c"

"""
#!/bin/bash

# URL de base
URL="http://localhost:83"

# Compteur pour les réponses
c=0

# Boucle pour 500 appels
for i in {1..500}; do
    # Effectuer un appel curl
    response=$(curl -s "$URL")
    
    # Vérifier la réponse (attention à la casse et à l'usage de guillemets)
    if [[ "$response" == *"Hello 1"* ]]; then
        ((c+=1)) # Incrémenter le compteur pour "Hello 1"
    fi
done

echo "c=$c"
 
"""




