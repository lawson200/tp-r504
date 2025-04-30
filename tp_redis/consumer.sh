

list= "msg"
$thres=32000

while :
do
	ls=$(redis-cli --raw LLEN list)
	if [ $ls -gt 0 ]
	then
		values=$(redis-cli --raw LLEN list)
		ls=$(redis-cli --raw LLEN list)
		if ! [ "$value" = "" ]
		then 
				if [ $value -gt $thres ]
				then
					sleep $delay
				fi
		fi
		x=$(( $x+1))
	else
		echo "liste vide, terminaison"
	exit 0
	fi
done
