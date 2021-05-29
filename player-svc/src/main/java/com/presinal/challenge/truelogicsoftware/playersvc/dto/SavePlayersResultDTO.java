/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.presinal.challenge.truelogicsoftware.playersvc.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mpresinal
 */
public class SavePlayersResultDTO {
    private List<String> result;

    public List<String> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }
}
