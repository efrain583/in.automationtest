#!/usr/bin/bash


#  Hardcoding the entire configuration makes it hard to mantain a .json file is more covenient
#
# /c/'Program Files'/Java/jdk1.8.0_161/bin/java -jar /c/Users/efrain583/dev/ExternalJarFiles/SeleniumStandAloneServer/selenium-server-standalone-3.11.0.jar -role node -hub http://192.168.1.15:4444/grid/register -port 5555
#

#JAVA_BIN=`echo "/c/'Program Files'/Java/jdk1.8.0_161/bin"`
SEL_SERVER=/c/Users/efrain583/dev/ExternalJarFiles/SeleniumStandAloneServer/selenium-server-standalone-3.14.0.jar
F_DRIVER=/c/Users/efrain583/dev/ExternalJarFiles/SeleniumDrivers/geckodriver.exe
C_DRIVER=/c/Users/efrain583/dev/ExternalJarFiles/SeleniumDrivers/chromedriver.exe

/c/'Program Files'/Java/jdk1.8.0_161/bin/java -Dwebdriver.gecko.driver=$F_DRIVER -Dwebdriver.chrome.driver=$C_DRIVER -jar $SEL_SERVER -role node -nodeConfig seleniumGridConf.json

