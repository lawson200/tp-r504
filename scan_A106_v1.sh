#!/bin/bash

# Définir la plage d'adresses IP à scanner (vous pouvez adapter cela en fonction de votre réseau)
IP_RANGE="172.16.0.0/24"

# Fichier de sortie CSV
OUTPUT_FILE="scan-result_1.csv"

# En-têtes du fichier CSV
echo "IP,Open Ports" > "$OUTPUT_FILE"

# Lancer le scan Nmap avec l'option -F pour scanner les 1000 premiers ports
nmap -F --open -oG - "$IP_RANGE" | grep "Host:" | while read line; do
    # Extraire l'IP
    IP=$(echo $line | awk '{print $2}')
    
    # Compter le nombre de ports ouverts
    OPEN_PORTS=$(echo $line | grep -oP "\d+/tcp" | wc -l)

    # Ajouter les résultats au fichier CSV
    echo "$IP,$OPEN_PORTS" >> "$OUTPUT_FILE"
done

echo "Scan terminé. Résultats enregistrés dans $OUTPUT_FILE"





#while read VAR
#do
#echo $var ; echo ${var:1}
#done < active_hosts.txt
