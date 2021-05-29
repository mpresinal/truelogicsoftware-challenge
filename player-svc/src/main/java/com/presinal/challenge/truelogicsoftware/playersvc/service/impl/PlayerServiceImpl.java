/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service.impl;

import com.presinal.challenge.truelogicsoftware.playersvc.domain.SavePlayerResult;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerProducer;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerRepository;
import com.presinal.challenge.truelogicsoftware.playersvc.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mpresinal
 */
@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository;
    
    @Autowired
    private PlayerProducer producer;
    
    @Override
    @Transactional(readOnly = false)
    public SavePlayerResult savePlayer(Player player) {   
        if (player == null) {
            throw new NullPointerException("player cannot be null");
        }
        
        String playerName = player.getName();
        if (player.isExpert()) {
            repository.save(player);
            return SavePlayerResult.storedInDB(playerName);
        } else if (player.isNovice()) {
            producer.send(player);
            return SavePlayerResult.sentToKafkaTopic(playerName);
        } else {
            return SavePlayerResult.notFit(playerName);
        }        
    }
    
}
