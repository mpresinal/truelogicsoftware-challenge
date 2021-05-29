/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service.impl;

import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author mpresinal
 */
@Component
public class KafkaPlayerProducer implements PlayerProducer {

    @Value("${topic.name}")
    private String topicName;
    
    private KafkaTemplate<String, Player> kafkaTemplate;

    public KafkaPlayerProducer(KafkaTemplate<String, Player> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }    
    
    @Override
    public void send(Player player) {
        kafkaTemplate.send(topicName, player);
    }
}
