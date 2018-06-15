#!/usr/bin/bash
#
# This script runs a testng xml suite file for the in.automationtest project
# Much better to do this using Maven
# Instead of a bash script
#
# u Treat unset variables as an error when substituting.
# x Print commands and their arguments as they are executed`
set -ux

M2R=C:/Users/efrain/.m2/repository

LOCALJAR="C:/Users/efrain/git/in.automationtest/in.automationtest/target/in.automation_test.jar"
LOCALTESTDIR="C:/Users/efrain/git/in.automationtest/in.automationtest/target/test-classes/in/automationtest/tests/"
LOCALPKGDIR=C:/Users/efrain/git/in.automationtest/in.automationtest/target/test-classes
LOCALPAGEDIR="C:/Users/efrain/git/in.automationtest/in.automationtest/target/test-classes/in/automationtest/pages/"

# Create a jar file may be added in the CLASSPATH below
C:/'Program Files'/Java/jdk1.8.0_121/bin/jar cvf $LOCALJAR -C $LOCALPAGEDIR .
C:/'Program Files'/Java/jdk1.8.0_121/bin/jar uvf $LOCALJAR -C $LOCALTESTDIR .

sleep 5
# For it to work you have use quotes in the CLASSPATH assigment  and do the export in the next line
CLASSPATH="${LOCALPKGDIR};${M2R}/UtilKit/AutomationUtilities/1.0/AutomationUtilities-1.0-tests.jar;$M2R/org/apache/maven/plugins/maven-jxr-plugin/2.3/maven-jxr-plugin-2.3.jar;$M2R/org/apache/velocity/velocity/1.5/velocity-1.5.jar;$M2R/commons-collections/commons-collections/3.1/commons-collections-3.1.jar;$M2R/commons-lang/commons-lang/2.1/commons-lang-2.1.jar;$M2R/oro/oro/2.0.8/oro-2.0.8.jar;$M2R/org/apache/maven/maven-jxr/2.3/maven-jxr-2.3.jar;$M2R/org/apache/maven/maven-plugin-api/2.0.9/maven-plugin-api-2.0.9.jar;$M2R/org/apache/maven/maven-project/2.0.9/maven-project-2.0.9.jar;$M2R/org/apache/maven/maven-settings/2.0.9/maven-settings-2.0.9.jar;$M2R/org/apache/maven/maven-profile/2.0.9/maven-profile-2.0.9.jar;$M2R/org/apache/maven/maven-artifact-manager/2.0.9/maven-artifact-manager-2.0.9.jar;$M2R/org/apache/maven/maven-repository-metadata/2.0.9/maven-repository-metadata-2.0.9.jar;$M2R/org/apache/maven/maven-plugin-registry/2.0.9/maven-plugin-registry-2.0.9.jar;$M2R/org/apache/maven/maven-artifact/2.0.9/maven-artifact-2.0.9.jar;$M2R/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.jar;$M2R/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.jar;$M2R/org/apache/maven/maven-model/2.0.9/maven-model-2.0.9.jar;$M2R/org/apache/maven/reporting/maven-reporting-api/3.0/maven-reporting-api-3.0.jar;$M2R/org/apache/maven/reporting/maven-reporting-impl/2.1/maven-reporting-impl-2.1.jar;$M2R/org/apache/maven/doxia/doxia-core/1.1.2/doxia-core-1.1.2.jar;$M2R/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar;$M2R/commons-validator/commons-validator/1.2.0/commons-validator-1.2.0.jar;$M2R/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar;$M2R/commons-digester/commons-digester/1.6/commons-digester-1.6.jar;$M2R/org/apache/maven/wagon/wagon-provider-api/1.0/wagon-provider-api-1.0.jar;$M2R/org/apache/maven/doxia/doxia-site-renderer/1.2/doxia-site-renderer-1.2.jar;$M2R/org/apache/maven/doxia/doxia-logging-api/1.2/doxia-logging-api-1.2.jar;$M2R/org/apache/maven/doxia/doxia-decoration-model/1.2/doxia-decoration-model-1.2.jar;$M2R/org/apache/maven/doxia/doxia-module-xhtml/1.2/doxia-module-xhtml-1.2.jar;$M2R/org/apache/maven/doxia/doxia-module-fml/1.2/doxia-module-fml-1.2.jar;$M2R/org/codehaus/plexus/plexus-i18n/1.0-beta-7/plexus-i18n-1.0-beta-7.jar;$M2R/org/codehaus/plexus/plexus-velocity/1.1.7/plexus-velocity-1.1.7.jar;$M2R/org/apache/maven/doxia/doxia-sink-api/1.2/doxia-sink-api-1.2.jar;$M2R/org/codehaus/plexus/plexus-utils/1.5.8/plexus-utils-1.5.8.jar;$M2R/xalan/xalan/2.7.0/xalan-2.7.0.jar;$M2R/org/seleniumhq/selenium/selenium-java/3.5.3/selenium-java-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-api/3.5.3/selenium-api-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-chrome-driver/3.5.3/selenium-chrome-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-edge-driver/3.5.3/selenium-edge-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-firefox-driver/3.5.3/selenium-firefox-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-ie-driver/3.5.3/selenium-ie-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-opera-driver/3.5.3/selenium-opera-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-remote-driver/3.5.3/selenium-remote-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-safari-driver/3.5.3/selenium-safari-driver-3.5.3.jar;$M2R/org/seleniumhq/selenium/selenium-support/3.5.3/selenium-support-3.5.3.jar;$M2R/cglib/cglib-nodep/3.2.4/cglib-nodep-3.2.4.jar;$M2R/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar;$M2R/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar;$M2R/commons-codec/commons-codec/1.10/commons-codec-1.10.jar;$M2R/commons-io/commons-io/2.5/commons-io-2.5.jar;$M2R/commons-logging/commons-logging/1.2/commons-logging-1.2.jar;$M2R/org/w3c/css/sac/1.3/sac-1.3.jar;$M2R/net/sourceforge/cssparser/cssparser/0.9.23/cssparser-0.9.23.jar;$M2R/com/google/code/gson/gson/2.8.0/gson-2.8.0.jar;$M2R/com/google/guava/guava/23.0/guava-23.0.jar;$M2R/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar;$M2R/com/google/errorprone/error_prone_annotations/2.0.18/error_prone_annotations-2.0.18.jar;$M2R/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar;$M2R/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar;$M2R/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar;$M2R/net/sourceforge/htmlunit/htmlunit-core-js/2.27/htmlunit-core-js-2.27.jar;$M2R/net/sourceforge/htmlunit/neko-htmlunit/2.27/neko-htmlunit-2.27.jar;$M2R/org/apache/httpcomponents/httpclient/4.5.3/httpclient-4.5.3.jar;$M2R/org/apache/httpcomponents/httpcore/4.4.6/httpcore-4.4.6.jar;$M2R/org/apache/httpcomponents/httpmime/4.5.3/httpmime-4.5.3.jar;$M2R/org/eclipse/jetty/jetty-client/9.4.5.v20170502/jetty-client-9.4.5.v20170502.jar;$M2R/org/eclipse/jetty/jetty-http/9.4.5.v20170502/jetty-http-9.4.5.v20170502.jar;$M2R/org/eclipse/jetty/jetty-io/9.4.5.v20170502/jetty-io-9.4.5.v20170502.jar;$M2R/org/eclipse/jetty/jetty-util/9.4.5.v20170502/jetty-util-9.4.5.v20170502.jar;$M2R/net/java/dev/jna/jna/4.1.0/jna-4.1.0.jar;$M2R/net/java/dev/jna/jna-platform/4.1.0/jna-platform-4.1.0.jar;$M2R/junit/junit/4.12/junit-4.12.jar;$M2R/com/codeborne/phantomjsdriver/1.4.0/phantomjsdriver-1.4.0.jar;$M2R/org/seleniumhq/selenium/htmlunit-driver/2.27/htmlunit-driver-2.27.jar;$M2R/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar;$M2R/org/eclipse/jetty/websocket/websocket-api/9.4.5.v20170502/websocket-api-9.4.5.v20170502.jar;$M2R/org/eclipse/jetty/websocket/websocket-client/9.4.5.v20170502/websocket-client-9.4.5.v20170502.jar;$M2R/org/eclipse/jetty/websocket/websocket-common/9.4.5.v20170502/websocket-common-9.4.5.v20170502.jar;$M2R/xalan/serializer/2.7.2/serializer-2.7.2.jar;$M2R/xerces/xercesImpl/2.11.0/xercesImpl-2.11.0.jar;$M2R/mysql/mysql-connector-java/6.0.6/mysql-connector-java-6.0.6.jar;$M2R/net/sourceforge/htmlunit/htmlunit/2.26/htmlunit-2.26.jar;$M2R/org/testng/testng/6.10/testng-6.10.jar;$M2R/com/beust/jcommander/1.48/jcommander-1.48.jar;$M2R/org/apache/poi/poi-ooxml/3.16/poi-ooxml-3.16.jar;$M2R/org/apache/poi/poi/3.16/poi-3.16.jar;$M2R/org/apache/commons/commons-collections4/4.1/commons-collections4-4.1.jar;$M2R/org/apache/poi/poi-ooxml-schemas/3.16/poi-ooxml-schemas-3.16.jar;$M2R/org/apache/xmlbeans/xmlbeans/2.6.0/xmlbeans-2.6.0.jar;$M2R/stax/stax-api/1.0.1/stax-api-1.0.1.jar;$M2R/com/github/virtuald/curvesapi/1.04/curvesapi-1.04.jar;$M2R/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar;$M2R/log4j/log4j/1.2.17/log4j-1.2.17.jar;$M2R/com/jcabi/jcabi-log/0.17.1/jcabi-log-0.17.1.jar;$M2R/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar;$M2R/com/jcabi/jcabi-aspects/0.22/jcabi-aspects-0.22.jar;$M2R/org/aspectj/aspectjrt/1.8.4/aspectjrt-1.8.4.jar;$M2R/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar;$M2R/com/sun/mail/javax.mail/1.5.2/javax.mail-1.5.2.jar;$M2R/javax/activation/activation/1.1/activation-1.1.jar;$M2R/org/fluttercode/datafactory/datafactory/0.8/datafactory-0.8.jar;$M2R/net/sf/jsqlparser/jsqlparser/0.8.0/jsqlparser-0.8.0.jar"
export CLASSPATH

echo
echo
echo $CLASSPATH
echo
echo

export SUITEDIR=C:/Users/efrain/git/in.automationtest/in.automationtest/test-output
echo
echo

java -cp ${CLASSPATH} org.testng.TestNG $SUITEDIR/testng-failed.xml 

exit 0