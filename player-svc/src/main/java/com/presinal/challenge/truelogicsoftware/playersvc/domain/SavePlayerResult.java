/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.domain;

/**
 *
 * @author mpresinal
 */
public class SavePlayerResult {
    
    public enum ActionTaken {
        STORED_IN_DB("stored in DB"), 
        SENT_TO_KAFKA_TOPIC("sent to Kafka topic"), 
        NOT_FIT("did not fit");
        
        private String description;
        ActionTaken(String message) {
            this.description = message;
        }
        
        public String getDescription() {
            return description;
        }
    }    
    
    private ActionTaken actionTaken;
    private String playerName;
    private String description;

    public SavePlayerResult(String playerName, ActionTaken actionTaken) {
        this.actionTaken = actionTaken;
        this.playerName = playerName;
        
        description = String.format("player %s %s", playerName, actionTaken.getDescription());
    }
    
    public static SavePlayerResult storedInDB(String playerName) {
        return new SavePlayerResult(playerName, ActionTaken.STORED_IN_DB);
    }
    
    public static SavePlayerResult sentToKafkaTopic(String playerName) {
        return new SavePlayerResult(playerName, ActionTaken.SENT_TO_KAFKA_TOPIC);
    }
    
    public static SavePlayerResult notFit(String playerName) {
        return new SavePlayerResult(playerName, ActionTaken.NOT_FIT);
    }        
    
    public String getDescription() {
        return description;
    }

    public ActionTaken getActionTaken() {
        return actionTaken;
    }

    @Override
    public String toString() {
        return "SavePlayerResult{" + "actionTaken=" + actionTaken + ", playerName=" + playerName + ", description=" + description + '}';
    }
}
