package com.presinal.challenge.truelogicsoftware.playersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.presinal.challenge.truelogicsoftware.playersvc.config")
public class PlayerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerSvcApplication.class, args);
	}

}
