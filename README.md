# Product Service

Service for handling all product related operations

### Depends on

- MongoDB instance

## APIs

| Functionality | REST Endpoint | Parameter | Body | Response |
| --- | --- | --- | --- | --- |
| Get Information of all Products | **GET** `/product/all` |     |     | JSON String |
| Get Information of all Similar Products | **GET** `/product/similar` | query - String |     | JSON String |
| Get Information of Products by Pincode | **GET** `/product/allByPin` | pincode - String |     | JSON String |
| Get Information of Products by Id | **GET** `/product/id` | prodId - String |     | JSON String |
| Get Information of Products by Category | **GET** `/product/allByCategory` | category - String |     | JSON String |
| Add New Product | **POST** `/product/add` |     | JSON String | JSON String |
| Update Product | Not Implemented |     |     |     |
| Enable Product | Not Implemented |     |     |     |
| Disable Product | Not Implemented |     |     |     |
| Add New Category | **POST** `/category/add` | category - String |     | JSON String |

## Configuration

Edit the properties of **application.yml** file

```yaml
# Eureka properties
eureka:
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      defaultZone: address of the eureka server (Eg: http://localhost:8761/eureka)
  instance:
    hostname: specify the hostname of service here (Eg: localhost)

# Server properties
server:
  port: port in which the product service is to be run (Eg: 8094)

# Application properties
spring:
  application:
    name: name of the application (Eg: PRODUCT-SERVICE)
# MongoDB properties
  data:
    mongodb:
      database: mongoDB database name (Eg: testWorkingDB)
      host: name of mongoDB host (Eg: localhost)
      port: port in which mongoDB is being run (Eg: 27017)
```

## Local Deployment

Service Registry should be started for successful execution of all queries.

In application.yml file, change the properties

| Property | Value | Example |
| --- | --- | --- |
| eureka_hostname | hostname of eureka server | service-registry |
| service_hostname | hostname of service (try to use the same as in docker-compose) | product-service |
| mongodb_hostname | hostname of mongodb | product-db |
| mongodb\_database\_name | database name | productDB |

### Using Docker

Create docker bridge network: `docker network create -d bridge pigihi-network`

docker-compose can be used to run the application and the corresponding mongodb instance

1.  Go to project folder
2.  Open terminal and run `docker-compose up`
3.  The application can be accessed at localhost:8094 (port 8094 is set in docker-compose)
4.  MongoDB port is set to 27021

To run only the application

1.  Go to project folder
2.  Open terminal and run `docker build .`
3.  Run `docker run -p 8094:8094 docker_image_name`
4.  The application can be accessed at localhost:8094

### Using Gradle

MongoDB should be run seperately and the configurations should be updated in application.yml

1.  Go to project folder
2.  Open terminal and run `./gradlew build`
3.  Run `./gradlew bootRun`

* * *
