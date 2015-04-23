# target file
TF='./xiaomin';
# output file
OF='./ddd';
TEMP='./TEMP_FILE.csv'

AZURE='AzureStorageInstanceResponse';
APPENGINE='AppEngineInstanceResponse';
AMAZON='AmazonInstanceResponse';

for i in 100 300 500 700 900 1100;
do
	# filter file we need, get ride of those *timestamp* or *group* ....
	files=`find $TF/*.csv | grep "_"$i"_3_0.csv$"`
	
	# output file
	tempAzure=$OF"/"$AZURE"_"$i".csv";
	tempApp=$OF"/"$APPENGINE"_"$i".csv";
	tempAmazon=$OF"/"$AMAZON"_"$i".csv";

	for j in $files;
	do
		# get the description of the file
		temp=`sed -n '2,1p' $j | awk -F',' '{print $1}'`
		
		# merge all the 'Azure'
		if [ $temp = $AZURE ]; then
			# filter out all the error
			cat $j | grep -v "null" >> $tempAzure;
		elif [ $temp = $APPENGINE ]; then
			cat $j | grep -v "null" >> $tempApp;
		elif [ $temp = $AMAZON ]; then
			cat $j | grep -v "null" >> $tempAmazon;
		fi;
	done;

	###############################################################
	# sort by starting time
	cat $tempAzure | sort -t, -k5 > $TEMP;
	
	# get 300 lines, starting from line 301 | awk -F',' '{print $2}'
	sed -n $i",+"$i"p" $TEMP  > $tempAzure
	rm -f $TEMP
	###############################################################
	cat $tempApp | sort -t, -k5 > $TEMP;
	
	# get 300 lines, starting from line 301 | awk -F',' '{print $2}'
	sed -n $i",+"$i"p" $TEMP  > $tempApp
	rm -f $TEMP
	###############################################################
	cat $tempAmazon | sort -t, -k5 > $TEMP;
	
	# get 300 lines, starting from line 301 | awk -F',' '{print $2}'
	sed -n $i",+"$i"p" $TEMP  > $tempAmazon
	rm -f $TEMP


done;
