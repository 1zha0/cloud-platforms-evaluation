#!/bin/bash

val=`cat ~/wsclients/wsclients/THREADS.txt`;
if [ $val == '100' ]; then
	echo '300' > ~/wsclients/wsclients/THREADS.txt;
elif [ $val == '300' ]; then
	echo '500' > ~/wsclients/wsclients/THREADS.txt;
elif [ $val == '500' ]; then
	echo '700' > ~/wsclients/wsclients/THREADS.txt;
elif [ $val == '700' ]; then
	echo '900' > ~/wsclients/wsclients/THREADS.txt;
elif [ $val == '900' ]; then
	echo '1100' > ~/wsclients/wsclients/THREADS.txt;
else 
	echo '100' > ~/wsclients/wsclients/THREADS.txt;
fi

