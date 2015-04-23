#get all the log which contain amazon
#
#for i in ./logg/*.log; 
#do 
#content=`cat $i | grep -i 'amazon' | wc | awk '{print $1}'`;
#	if [ "$content" = "0" ]; then 
#		rm $i;
#	fi
#done;

#count how many [Could not send Message.] appear in the
#
#for i in ./logg/*.log;
#do
#num=`cat $i | grep 'Could not send Message.' | wc | awk '{print $1}'`;
#echo "$i [Could not send Message. Error] $num"
#done;


# Loop through all the file, calculate all the error by round
for i in ./data/*.csv;
do
cat $i | awk -F',' '{print $1,$4,$8}' | grep -v 'No Error' > ./TEMP.FILE;

# remove the first line (none data)
sed -i 1d ./TEMP.FILE

echo "$i,ServerError,ConnectoinError"

	for round in {0..5};
	do
		se=`cat ./TEMP.FILE | grep " $round" | grep 'Server Error' | wc | awk '{print $1}'`;
		ce=`cat ./TEMP.FILE | grep " $round" | grep 'Connection Error' | wc | awk '{print $1}'`;
		desc=`sed -n '2,1p' $i | awk -F',' '{print $1}'`

		echo "$desc,Round $round,$se,$ce";
	done;

rm ./TEMP.FILE;

done;
