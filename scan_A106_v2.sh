
# Définir la plage d'adresses IP à scanner (vous pouvez adapter cela en fonction de votre réseau)
IP_RANGE="172.16.0.0/24"

# Fichier de sortie CSV
OUTPUT_FILE="scan-result_2.csv"

# En-têtes du fichier CSV
echo "IP,Open TCP Ports,Open UDP Ports" > "$OUTPUT_FILE"

# Lancer le scan Nmap pour les ports TCP et UDP
nmap -F --open -oG - "$IP_RANGE" | grep "Host:" | while read line; do
    # Extraire l'IP
    IP=$(echo $line | awk '{print $2}')
    
    # Compter le nombre de ports TCP ouverts
    OPEN_TCP_PORTS=$(echo $line | grep -oP "\d+/tcp" | wc -l)
    
    # Compter le nombre de ports UDP ouverts
    OPEN_UDP_PORTS=$(echo $line | grep -oP "\d+/udp" | wc -l)

    # Ajouter les résultats au fichier CSV
    echo "$IP,$OPEN_TCP_PORTS,$OPEN_UDP_PORTS" >> "$OUTPUT_FILE"
done

echo "Scan terminé. Résultats enregistrés dans $OUTPUT_FILE"

