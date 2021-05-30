# Truelogic Software challenge

Description
------------------------
Create a REST service with spring and spring boot. The REST Service must have a POST endpoint that receives an array of players:
```
{
  "players": [
    {
      "name": "Sub zero",
      "type": "expert"
    },
    {
      "name": "Scorpion",
      "type": "novice"
    },
    {
      "name": "Reptile",
      "type": "meh"
    }
  ]
}
```
For each "player" object based on its "type" property the player will be:
- stored in H2 database if the type is "expert".
- sent to kafka topic if the type is "novice".
- if the type does not fit one of the above, you will let the user know in the endpoint response.

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
When the project gets up and running you can start sending requests to the players service with the endpoint: http://localhost:8080/players

To read the messagas sent to the topic run:
```
kafka-console-consumer.sh --topic players --from-beginning --bootstrap-server localhost:9092
```

How to test the players service
------------------------
You can test the players service with swagger ui at: http://localhost:8080/swagger-ui/#/player-controller/savePlayersUsingPOST
