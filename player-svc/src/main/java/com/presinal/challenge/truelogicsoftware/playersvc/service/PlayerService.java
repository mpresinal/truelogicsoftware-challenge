/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service;

import com.presinal.challenge.truelogicsoftware.playersvc.domain.SavePlayerResult;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;

/**
 *
 * @author mpresinal
 */
public interface PlayerService {
    
    /**
     * Save the player based on its type in DB or send it to topic queue.
     * @param player
     * @return a new <code>SavePlayerResult</code>
     */
    public SavePlayerResult savePlayer(Player player);
}
