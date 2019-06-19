## Building and running using Eventuate Local

First, build the application:

```
./gradlew assemble -P eventuateDriver=local
```

Next, you can launch the application using Docker Compose

```
export DOCKER_HOST_IP=Public IP address of your instance on which you are running the application or if you are running on local machine put IP address of your local machine.
docker-compose -f docker-compose-eventuate-local-mysql.yml build
docker-compose -f docker-compose-eventuate-local-mysql.yml up
```



* `http://${DOCKER_HOST_IP?}:8888/swagger-ui.html` - Create a customer
* `http://${DOCKER_HOST_IP?}:8083/swagger-ui.html` - Create an order
* `http://${DOCKER_HOST_IP?}:8082/swagger-ui.html` - View the customer and the order

```
