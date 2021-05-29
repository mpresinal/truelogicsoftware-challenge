/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.controller;

import com.presinal.challenge.truelogicsoftware.playersvc.dto.PlayersDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.dto.SavePlayersResultDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerService;
import com.presinal.challenge.truelogicsoftware.playersvc.service.exception.NotSupportedPlayerTypeException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mpresinal
 */
@RestController
@RequestMapping(path="/players")
public class PlayerController {
 
    @Autowired
    private PlayerService service;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SavePlayersResultDTO savePlayers(@RequestBody @Validated PlayersDTO players) {
        SavePlayersResultDTO result = new SavePlayersResultDTO();
        players.getPlayers().forEach(p -> {
                result.getResult().add(service.savePlayer(p).getDescription());
        });

        return result;
    }
}