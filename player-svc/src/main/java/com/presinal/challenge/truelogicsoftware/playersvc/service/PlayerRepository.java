/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service;

import com.presinal.challenge.truelogicsoftware.playersvc.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mpresinal
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
