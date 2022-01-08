<h1>Online Banking</h1>


<h2>Application Arquiteture</h2>

<img src="./assets/Migração monolitico para serviços.png"/>
<h2>How to run the application</h2>

First you need in the root execute the command:

```mvn clean install -DskipTests```

After that execute the next commands:

```
 $~/cd core
 $~/core/ mvn clean install -DskipTests
 
 $~/cd token
 $~/token/ mvn clean install -DskipTests

 $~/cd discorery
 $~/discovery/ mvn clean install -DskipTests
 $-/discovery/ java -jar target/discovery.jar

 $~/cd gateway
 $~/gateway/ mvn clean install -DskipTests
 $-/gateway/ java -jar target/discovery.jar

 $~/cd auth 
 $~/auth/ mvn clean install -DskipTests
 $~/auth/ java -jar target/course.jar

 $~/cd course
 $~/course/ mvn clean install -DskipTests
 $~/auth/ java -jar target/course.jar

 ```
