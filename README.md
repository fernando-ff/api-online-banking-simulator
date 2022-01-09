<h1>Online Banking</h1>

Link for the original project https://github.com/dmitrykhramov/Online-Bank-Simulator.

<h2>Application Arquiteture</h2>

<img src="./assets/Migração monolitico para serviços.png"/>
<h2>How to run the application</h2>
If you don,t have the Mysql in your machine and have the docker and docker compose, there is a docker compose to set up a mysql inside a container, to run it, execute thhe next commands:

```
    $~/cd docker/database
    $~/docker-compose up --build
```

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
<h2>References</h2>


- https://www.youtube.com/watch?v=vxeMnM15gsI&list=PL62G310vn6nH_iMQoPMhIlK_ey1npyUUl
- https://www.baeldung.com/dockerizing-spring-boot-application
- https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/
