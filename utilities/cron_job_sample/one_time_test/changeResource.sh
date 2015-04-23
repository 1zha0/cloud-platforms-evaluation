#!/bin/bash

val=`cat ~/wsclients/wsclients/RESOURCE.txt`;
if [ $val == '1' ]; then
	echo '100' > ~/wsclients/wsclients/RESOURCE.txt;
elif [ $val == '100' ]; then
	echo '1000' > ~/wsclients/wsclients/RESOURCE.txt;
else 
	echo '1' > ~/wsclients/wsclients/RESOURCE.txt;
fi

