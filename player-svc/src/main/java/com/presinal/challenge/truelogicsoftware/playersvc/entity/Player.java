/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author mpresinal
 */
@Entity
@Table(name = "PLAYER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "name", nullable = false)
    private String name;    
    @Column( name = "type", nullable = false)
    private String type;

    public Player() {
    }

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @JsonIgnore
    public boolean isExpert() {
        return "expert".equals(type);
    }
    
    @JsonIgnore
    public boolean isNovice() {
        return "novice".equals(type);
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
}
