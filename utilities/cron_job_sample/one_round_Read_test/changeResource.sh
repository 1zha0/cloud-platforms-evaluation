#!/bin/bash

val=`cat ~/wsclients/wsclients/RESOURCE.txt`;
if [ $val == '1' ]; then
	echo '2' > ~/wsclients/wsclients/RESOURCE.txt;
elif [ $val == '2' ]; then
	echo '3' > ~/wsclients/wsclients/RESOURCE.txt;
else 
	echo '1' > ~/wsclients/wsclients/RESOURCE.txt;
fi

