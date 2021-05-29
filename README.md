# truelogicssoftware-challenge

Requirements
------------------------
- Java 11
- Kafka 2.13-2.8.0
- Maven 3

How to build the project
------------------------
To build the project execute the command:
```
 mvn install
 ```

How to run the project
------------------------

First create the kafka topic with the following command: 
```
kafka-topics.sh --create --topic players --bootstrap-server localhost:9092
```

Run the project with the command: 
```
./mvnw spring-boot:run
```
When the project get up and running you can start sending request to the player service with the endpoint: http://localhost:8080/players

To read the messagas sent to the topic run:
```
kafka-console-consumer.sh --topic players --from-beginning --bootstrap-server localhost:9092
```

how test the player service
------------------------
You can test the players services with swagger ui at: http://localhost:8080/swagger-ui/#/player-controller/savePlayersUsingPOST
