#!/bin/bash

errAccessDeny=0
errTooManyOpenFile=0
errZeroSizedReply=0
emptyLine=0
errReadTimedOut=0
errNetworkError=0
errUnknownHost=0
errServerError=0
errConnectionTimeOutError=0

# Loop through all the file, remove all the timestap.
for file in ./testlog/*.log
do
  #fileName=`echo $file | cut -d'/' -f3`
  emptyL=`cat $file | grep "   $" | wc -l`
  accessError=`cat $file | grep "Access Denied" | wc -l`
  tooManyOpenFileError=`cat $file | grep "SocketException: Too many open files" | wc -l`
  zeroSizedReplyError=`cat $file | grep "Zero Sized Reply" | wc -l`
  readTimedOutError=`cat $file | grep "Read timed out" | wc -l`
  networkError=`cat $file | grep "Network Error (tcp_error)" | wc -l`
  unKnownHostError=`cat $file | grep "UnknownHostException" | wc -l`
  serverError=`cat $file | grep "\[INFO\] ERROR" | grep "Server Error" | wc -l`
  connectionTimeOutError=`cat $file | grep "\[INFO\] ERROR" | grep "Connection timed out" | wc -l`
  readError=`cat $file | grep "Read Error" | wc -l`


  emptyLine=`expr $emptyLine + $emptyL`
  errAccessDeny=`expr $errAccessDeny + $accessError`
  errTooManyOpenFile=`expr $errTooManyOpenFile + $tooManyOpenFileError`
  errZeroSizedReply=`expr $errZeroSizedReply + $zeroSizedReplyError`
  errReadTimedOut=`expr $errReadTimedOut + $readTimedOutError`
  errNetwork=`expr $errNetwork + $networkError`
  errUnknownHost=`expr $errUnknownHost + $unKnownHostError`
  errServerError=`expr $errServerError + $serverError`
  errReadError=`expr $errReadError + $readError`
  errConnectionTimeOutError=`expr $errConnectionTimeOutError + $connectionTimeOutError`
done

errZeroSizedReply=`expr $errZeroSizedReply / 3`
errAccessDeny=`expr $errAccessDeny + $emptyLine`
errAccessDeny=`expr $errAccessDeny / 3`
errNetwork=`expr $errNetwork / 3`
errReadError=`expr $errReadError / 3`

echo "The number of <Access Denied> is: "$errAccessDeny
echo "The number of <Too many open files> is: "$errTooManyOpenFile
echo "The number of <Zero Sized Reply> is: "$errZeroSizedReply
echo "The number of <Read timed out> is: "$errReadTimedOut
echo "The number of <Network Error (tcp_error)> is: "$errNetwork
echo "The number of <UnknownHostException: www-proxy.cse.unsw.edu.au> is: "$errUnknownHost
echo "The number of <Server Error> is: "$errServerError
echo "The number of <Read Error> is: "$errReadError
echo "The number of <Connection timed out> is: "$errConnectionTimeOutError

