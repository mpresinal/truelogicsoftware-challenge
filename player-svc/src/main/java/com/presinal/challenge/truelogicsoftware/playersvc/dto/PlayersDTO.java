/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.dto;

import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import java.util.List;

/**
 *
 * @author mpresinal
 */
public class PlayersDTO {
    
    //@Size
    private List<Player> players;

    public PlayersDTO() {
    }

    public PlayersDTO(List<Player> players) {
        this.players = players;
    }
    
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }    

    @Override
    public String toString() {
        return "PlayersDTO{" + "players=" + players + '}';
    }
}
