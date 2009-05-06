#!/bin/bash

MAVEN_DIR='./apache-maven-2.1.0'
if [ -d $MAVEN_DIR ]; then
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
export MAVEN_OPTS="-Xms256m -Xmx512m"
export PATH=$M2:$PATH
\cp ./settings.xml ./$MAVEN_DIR/conf

        echo ""
	echo '================= testing command "mvn --version" ================='
mvn --version
