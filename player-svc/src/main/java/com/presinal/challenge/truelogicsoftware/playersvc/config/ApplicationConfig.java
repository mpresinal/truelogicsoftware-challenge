package com.presinal.challenge.truelogicsoftware.playersvc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mpresinal
 */
@Configuration
@ComponentScan(basePackages = { 
    "com.presinal.challenge.truelogicsoftware.playersvc.service",
    "com.presinal.challenge.truelogicsoftware.playersvc.controller"
})
@EntityScan(basePackages = "com.presinal.challenge.truelogicsoftware.playersvc.entity")
public class ApplicationConfig {
    
}
