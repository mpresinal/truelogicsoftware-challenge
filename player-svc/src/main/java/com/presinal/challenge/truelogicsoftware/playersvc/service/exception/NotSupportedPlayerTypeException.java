/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.service.exception;

/**
 *
 * @author mpresinal
 */
public class NotSupportedPlayerTypeException extends Exception {

    private String type;
    public NotSupportedPlayerTypeException(String type) {
        super(type + " is not supported");
    }

    public String getType() {
        return type;
    }
}
