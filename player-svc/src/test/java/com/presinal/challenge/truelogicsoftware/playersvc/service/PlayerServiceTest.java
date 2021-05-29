/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service;

import com.presinal.challenge.truelogicsoftware.playersvc.domain.SavePlayerResult;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author mpresinal
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayerServiceTest {
    
    private final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceTest.class);
    private final String RESP_DESC_FORMAT = "player %s %s";
    @MockBean
    private PlayerProducer playerProducer;    
    
    @Autowired
    private PlayerService service;
    
    @Test
    public void whenPlayerTypeIsExpert_saveInDB() {
        Mockito.doNothing().when(playerProducer).send(ArgumentMatchers.any(Player.class));
        SavePlayerResult result = service.savePlayer(new Player("Sub zero", "expert"));
        LOGGER.debug("result = " + result);
        assertEquals(result.getActionTaken(), SavePlayerResult.ActionTaken.STORED_IN_DB);
        assertEquals(String.format(RESP_DESC_FORMAT, "Sub zero", result.getActionTaken().getDescription()), result.getDescription());
    }
    
    @Test
    public void whenPlayerTypeIsNovice_sendToKafka() {
        Mockito.doNothing().when(playerProducer).send(ArgumentMatchers.any(Player.class));
        SavePlayerResult result = service.savePlayer(new Player("Scorpion", "novice"));        
        assertEquals(result.getActionTaken(), SavePlayerResult.ActionTaken.SENT_TO_KAFKA_TOPIC);
        assertEquals(String.format(RESP_DESC_FORMAT, "Scorpion", result.getActionTaken().getDescription()), result.getDescription());
    }
    
    @Test
    public void whenPlayerTypeIsOther_doNothing() {
        Mockito.doNothing().when(playerProducer).send(ArgumentMatchers.any(Player.class));
        SavePlayerResult result = service.savePlayer(new Player("Reptile", "meh"));        
        assertEquals(result.getActionTaken(), SavePlayerResult.ActionTaken.NOT_FIT);
    }
    
    @Test    
    public void whenPlayerTypeIsNull_doNothing() {
        Mockito.doNothing().when(playerProducer).send(ArgumentMatchers.any(Player.class));
        SavePlayerResult result = service.savePlayer(new Player("Reptile", null));        
        assertEquals(result.getActionTaken(), SavePlayerResult.ActionTaken.NOT_FIT);
    }
    
    @Test
    public void whenPlayerIsNull_throwNPE() {
        Mockito.doNothing().when(playerProducer).send(ArgumentMatchers.any(Player.class));
        assertThrows(NullPointerException.class, () -> service.savePlayer(null));        
    }
}
