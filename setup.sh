mvn clean install -DskipTests
cd core
mvn clean install -DskipTests
cd ..
cd token
mvn clean install -DskipTests
cd ..
cd discovery
mvn clean install -DskipTests
# gnome-terminal -x sh -c "java -jar target/discovery.jar"
cd ..
cd gateway
mvn clean install -Dskiptests
#gnome-terminal -x sh -c "java -jar target/gateway.jar"
cd ..
cd auth
mvn clean install -DskipTests
#gnome-terminal -x sh -c "java -jar target/auth.jar"
cd ..
cd recipient 
mvn clean install -DskipTests
#gnome-terminal -x sh -c "java -jar target/recipient.jar"
echo You need to run: java -jar target/jarName.jar on the folders
