#!/bin/bash

cd ~/wsclients/mavensetup

if [ -d ./apache-maven-2.1.0 ]; then
        echo ""
	echo "=================   apache-maven-2.1.0 existed.   ================="
else
        echo ""
	echo "=================   creating apache-maven-2.1.0   ================="
	tar jxvf apache-maven-2.1.0-bin.tar.bz2
fi

CURRENT_WORKING_DIR=`pwd`

        echo ""
        echo "=================         setting up env          ================="

export JAVA_HOME=/usr/lib/jvm/java-6-sun
export M2_HOME=${CURRENT_WORKING_DIR}/apache-maven-2.1.0
export M2=$M2_HOME/bin
export MAVEN_OPTS="-Xms512m -Xmx1024m"
export PATH=$M2:$PATH

        echo ""
	echo '================= testing command "mvn --version" ================='
mvn --version

cd ~/wsclients/wsclients

cp candidates/one_round_Read_test/CreateTests-AmazonSimpleDB.java src/main/java/org/unsw/eva/strategy/ThreadBaseStrategyTest.java 
cp candidates/one_round_Read_test/App.java src/main/java/org/unsw/eva/wsclient/App.java

mvn clean compile
