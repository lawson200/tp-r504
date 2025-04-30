n=1000
delay=3
while : 
do
	nb=$(redis-cli --raw LLEN list)
	echo "Envoi d'un burst de 1000 valeurs"
	for ((i=0; i<n; i++))
	do
		value=$RANDOM
		redis-cli LPUSH List "$value" > /dev/null
	done
done 
