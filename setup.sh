mvn clean install -DskipTests
cd core
mvn clean install -DskipTests
cd ..
cd token
mvn clean install -DskipTests
cd ..
cd discovery
mvn clean install -DskipTests
#java -jar target/discovery.jar
cd ..
cd gateway
mvn clean install -Dskiptests
#java -jar target/gateway.jar
cd ..
cd auth
mvn clean install -DskipTests
#java -jar target/auth.jar
cd ..
cd recipient 
mvn clean install -DskipTests
#java -jar target/recipient.jar
