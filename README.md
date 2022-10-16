## Introduction

One of the concepts/patterns used within a microservice-based architecture is database-per-microservice.  
The concept is straightforward. There is a data store for each microservice (whole schema or a table). Other services
are unable to access data repositories that they do not control.   
A solution like this has a lot of advantages.
Individual data storage, on the other hand, is easy to scale. Furthermore, the microservice encapsulates the domain's
data. As a result, understanding the service and its data as a whole is much easier. It's especially crucial for new
development team members.
It will take them less time and effort to properly comprehend the area for which they are responsible.  
The main drawback of this database service is that there is a need for a failure protection mechanism in case the
communication fails.

## Case Study

On this project we're trying to solve a problem where we have a single database available in our environment, and we'll
try to decrease the dependency on this oracle db.  
Also when we examined the traffic on a program like AppDynamics, we saw much traffic coming from three different
microservices to our **oracle db**.  
The solution presented here is from analytical approach .... by <u>analyzing our data</u>.  
To explain further, let's imagine our application serves some ecommerce data about stores,products and inventories and
all of these different data are stored
within a single database. Moreover, we can't apply our concept of **database-per-microservice** for any
kind of reason or limitation. By analyzing such data, we can implement the concept in a different way.

Let's start with storefronts & products, this kind of data rarely changes ... so what if we can load it to its
microservice on an in-memory database like **h2**?
so that each time we start e.g. products microservice, it's going to load this data from **oracle db** to an in-memory
database (h2).  
We can argue - but what if data changed? - then we can solve that via a typical http approach or preferably an **
event-driven** one.

## Components

* loader-ms
* orchestrator-ms
* storefront-ms
* products-ms

![](/samples/overview.svg "Overview")

## Testing

Run this command to start up the oracle db container.

```shell
docker run --name oracle_database -d -p 1521:1521 -e ORACLE_PASSWORD=Ali@1234 -v 'oracle_volume:/opt/oracle/oradata' gvenzl/oracle-xe
```

To switch between datasources/database modes (oracle - h2), specify spring boot running profile accordingly:  
* for h2 ---> spring.profiles.active=h2
* for oracle --> spring.profiles.active=oracle  

To access h2 consoles:
* [**storefront-ms**] http://localhost:8082/h2-console
* [**products-ms**] http://localhost:8083/h2-console

Results can be tested and verified via this [jmeter](/samples/test.jmx) file.  
Also, we've attached a [postman collections](/samples/demo.postman_collection.json) file.
## Conclusions/Results

We've concluded that our approach positively affected the performance as following:

1. Decreased traffic to oracle database.
2. Decreased overall response time for orchestrator-ms.

## Authors

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&label=Muhammad%20Ali)](https://linkedin.com/in/zatribune)
