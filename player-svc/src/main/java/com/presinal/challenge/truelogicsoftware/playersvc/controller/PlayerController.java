/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.controller;

import com.presinal.challenge.truelogicsoftware.playersvc.dto.PlayersDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.dto.SavePlayersResultDTO;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "players")
@RestController
@RequestMapping(path="/players")
public class PlayerController {
 
    @Autowired
    private PlayerService service;
    
    @ApiOperation(value = "Save the players based on its type in DB or send it to a kafka topic", 
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = SavePlayersResultDTO.class),
        @ApiResponse(code = 404, message = "Bad request", response = String.class),
        @ApiResponse(code = 505, message = "Internal server error", response = String.class)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SavePlayersResultDTO savePlayers(            
            @RequestBody @Validated PlayersDTO players) {
        SavePlayersResultDTO result = new SavePlayersResultDTO();
        players.getPlayers().forEach(p -> {
                result.getResult().add(service.savePlayer(p).getDescription());
        });

        return result;
    }
}