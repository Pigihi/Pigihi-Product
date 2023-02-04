# Product Service

Service for handling all product related operations

### Depends on:

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
    hostname: specify the hostname here (Eg: localhost)

# Server properties
server:
  port: port in which the customer service is to run (Eg: 8094)

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
