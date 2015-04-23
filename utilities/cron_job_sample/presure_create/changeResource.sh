#!/bin/bash

val=`cat ~/wsclients/wsclients/RESOURCE.txt`;
if [ $val == '100' ]; then
	echo '1024' > ~/wsclients/wsclients/RESOURCE.txt;
elif [ $val == '1024' ]; then
	echo '256000' > ~/wsclients/wsclients/RESOURCE.txt;
elif [ $val == '256000' ]; then
	echo '512000' > ~/wsclients/wsclients/RESOURCE.txt;
else 
	echo '100' > ~/wsclients/wsclients/RESOURCE.txt;
fi

