Commands:
xjc -p com.customer.rti.rim2016.v1_2.envelope.generated rti-rim-artefacts-2016-v1_2/envelope-v2-0-HMRC.xsd
xjc -p com.customer.rti.rim2016.v1_2.fps.generated rti-rim-artefacts-2016-v1_2/FullPaymentSubmission-2016-v1-2.xsd
cp -vpr com src/main/java/



Error when running: mvn clean:eclipse:clean eclipse:eclipse
[WARNING] An error occurred during dependency resolution of the following artifact:
    javax.jms:jms:1.1
Caused by: Could not transfer artifact javax.jms:jms:jar:1.1 from/to java.net (https://maven-repository.dev.java.net/nonav/repository): No connector available to access repository java.net (https://maven-repository.dev.java.net/nonav/repository) of type legacy using the available factories WagonRepositoryConnectorFactory
  javax.jms:jms:jar:1.1

from the specified remote repositories:
  central (http://repo.maven.apache.org/maven2, releases=true, snapshots=false),
  java.net (https://maven-repository.dev.java.net/nonav/repository, releases=true, snapshots=true)
Path to dependency: 
	1) com.customer.rti:RTIGateway:jar:1.0.0-SNAPSHOT
	2) log4j:log4j:jar:1.2.15
	3) javax.jms:jms:jar:1.1


Solution: 
cd lib/
mvn install:install-file -Dfile=jms-1.1.jar -DgroupId=javax.jms -DartifactId=jms -Dversion=1.1 -Dpackaging=jar

Sample output:
$ mvn install:install-file -Dfile=jms-1.1.jar -DgroupId=javax.jms -DartifactId=jms -Dversion=1.1 -Dpackaging=jar
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-install-plugin:2.4:install-file (default-cli) @ standalone-pom ---
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.pom
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.pom (3 KB at 1.7 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.1/plexus-3.1.pom
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.1/plexus-3.1.pom (19 KB at 25.6 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/17/spice-parent-17.pom
Downloaded: http://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/17/spice-parent-17.pom (7 KB at 17.2 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/10/forge-parent-10.pom
Downloaded: http://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/10/forge-parent-10.pom (14 KB at 23.4 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.pom
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.pom (2 KB at 2.8 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-components/1.1.7/plexus-components-1.1.7.pom
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-components/1.1.7/plexus-components-1.1.7.pom (5 KB at 12.9 KB/sec)
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.jar
Downloading: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.jar
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.jar (12 KB at 20.1 KB/sec)
Downloaded: http://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.jar (226 KB at 138.1 KB/sec)
[INFO] Installing /home/cloud/workspace/rti-gateway/rti/RTIGateway/lib/jms-1.1.jar to /home/cloud/.m2/repository/javax/jms/jms/1.1/jms-1.1.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.702s
[INFO] Finished at: Mon Feb 09 00:23:50 PHT 2015
[INFO] Final Memory: 9M/102M
[INFO] ------------------------------------------------------------------------


