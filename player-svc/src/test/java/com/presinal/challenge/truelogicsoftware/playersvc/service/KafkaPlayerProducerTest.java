package com.presinal.challenge.truelogicsoftware.playersvc.service;

import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import com.presinal.challenge.truelogicsoftware.playersvc.service.impl.KafkaPlayerProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.test.context.EmbeddedKafka;

/**
 *
 * @author mpresinal
 */
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = "players", ports = 9092)
@PropertySource("classpath:application.properties")
public class KafkaPlayerProducerTest {
    
    @Autowired
    private KafkaPlayerProducer producer;
    
    @Test
    public void testSendPlayer() {
        producer.send(new Player("Scorpion", "novice"));        
    }
    
}
