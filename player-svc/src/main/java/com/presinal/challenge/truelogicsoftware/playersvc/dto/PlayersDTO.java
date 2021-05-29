package com.presinal.challenge.truelogicsoftware.playersvc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import java.util.List;
import javax.validation.constraints.Size;

/**
 *
 * @author mpresinal
 */
@JsonInclude(Include.NON_NULL)
public class PlayersDTO {
    
    @Size(min = 1)
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
