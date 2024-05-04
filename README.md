# School Management System 


### 1. Java 17
### 2. Maven 3.9.6
### 3. MySQL
### 4. Docker
### 5. Redis
### 6. Spring Boot 3.2.5
### 7. Spring Cloud 2023.0.1
### 8. JWT 0.11.5
### 9. Modelmapper 3.2.0
### 10. lombok
### 11. MongoDB
 
 <p>&nbsp;</p>
 
### Spring Boot Modules:

 1. Web
 2. Actuator
 3. Security
 4. Data JPA
 5. Data redis
 6. Validation 
 7. Test
 8. data mongodb


### Spring Cloud Modules:

 1. Openfeign

 
### Microservices:

 1. Account Service [localhost:9071]
 2. Notification Service [localhost:9072]
 3. Service Register and Discovery [localhost:9080]
 4. Book Service [localhost:9073]

 
### Concepts Covered:

 1. CRUD operations  
 2. Logging using AOP 
 3. Global Exception Handling using AOP 
 4. Unit Testing using Junit  and Mockito  
 5. Distributed Caching using Redis 
 6. Authentication using JWT

MySQL: 3306
Redis: 6379
MongoDB: 27017


#### OpenAPI - Swagger UI:
http://localhost:9071/swagger-ui/index.html

#### Anguler :
http://localhost:4200/


Redis Commands:
docker exec -it some-redis bash
redis-cli
keys *


Docker Commands:
Note: start docker desktop

#### docker ps
#### docker ps -a [to see hidden containers]
#### docker image list


mvn clean install -DskipTests

docker build -t discoveryservice:latest .

docker run -p 9080:9080 --name discoveryservice  --network schoolmanagementsystem_default -it discoveryservice:latest

docker build -t notificationservice:latest .

docker run -p 9072:9072 --name notificationservice --network schoolmanagementsystem_default -it notificationservice:latest

docker build -t accountservice:latest .

docker run -p 9071:9071 --name accountservice --network schoolmanagementsystem_default -it accountservice:latest


