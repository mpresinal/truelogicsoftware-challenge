package com.presinal.challenge.truelogicsoftware.playersvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.presinal.challenge.truelogicsoftware.playersvc.dto.PlayersDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.dto.SavePlayersResultDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerProducer;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerRepository;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author mpresinal
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PlayerController.class)
public class PlayerControllerTest {
    
    private final Logger LOGGER = LoggerFactory.getLogger(PlayerControllerTest.class);    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private PlayerRepository repository;
    
    @MockBean
    private PlayerProducer producer;
    
    @Test
    public void whenInputIsNull_badRequest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void whenPlayersIsEmpty_badRequest() throws Exception {        
        mockMvc.perform(
                MockMvcRequestBuilders.post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PlayersDTO(new ArrayList<>())))
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());        
    }
    
    @Test
    public void whenValidInput_ok() throws Exception {
        List<Player> players = new ArrayList<>();        
        players.add(new Player("Sub zero", "expert"));
        players.add(new Player("Scorpion", "novice"));
        players.add(new Player("Reptile", null));
        
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PlayersDTO(players)))
        ).andReturn();
        
        String responseBody = result.getResponse().getContentAsString();        
        LOGGER.info("whenValidInput_ok():: response = " + responseBody);        
        
        assertNotNull(responseBody, "responseBody must not be nulll");
        
        SavePlayersResultDTO responseObject = objectMapper.readValue(new StringReader(responseBody), SavePlayersResultDTO.class);
        assertNotNull(responseObject, "responseObject must not be nulll");
        assertNotNull(responseObject.getResult(), "responseObject.result must not be nulll");
        assertFalse(responseObject.getResult().isEmpty(), "responseObject.result must not be empty");
    }
}
