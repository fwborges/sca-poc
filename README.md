# Employee Management Rest API

* Steps to run application:
* Execute first ***1-build-task.sh*** file to build jars.
* Execute ***2-start-services.sh*** to run docker containers.

#### Technologies and frameworks

* Java
* Maven
* Docker
* Spring Cloud(Config server) and Spring Data
* MongoDB
* etc

P.S.: Tradeoff using dependency injection and IOC by Spring on UseCases classes.

#### Swagger URL
* http://localhost:8080/swagger-ui.html

### Config Server URL
* http://localhost:8888/employee-api/default

### Mongo-express (GUI)
* Run docker-compose up mongo-express
* URL -> http://localhost:8081

### References and Study Guide
* https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
* https://www.infoq.com/br/presentations/transformando-sua-arquitetura-com-clean-architecture