# Airport Project

This is a simple project to demonstrate a client that creates tasks that workers then act on asynchronously.

This project is losely based on an airport terminal used to check in new passengers to their flights.

The terminal periodically adds a new CheckIn event to RabbitMQ. A seperate process listens for these new queue entries, and when found takes them off the queue and saves the Check In event into MongoDB.

To productionise this project the user would be expected to invest effort in multiple aspects such as security and logging. For example, all passwords should be extracted out Docker secrets.


## Requirements
- maven
- docker
- docker-compose
- Java 11

## To run:
### Set up Mongo and RabbitMQ:
Run the following command:
- `docker-compose up` 

### Run the terminal service
Run the terminal service.
- `cd terminal/`
- `mvn spring-boot:run`
