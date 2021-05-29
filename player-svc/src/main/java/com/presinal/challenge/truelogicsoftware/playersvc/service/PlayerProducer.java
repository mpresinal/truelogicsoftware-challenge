/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service;

import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;

/**
 *
 * @author mpresinal
 */
public interface PlayerProducer {
    
    void send(Player player);
}
