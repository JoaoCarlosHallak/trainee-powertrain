package com.hallak.escuderiaIdeas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hallak.escuderiaIdeas")
public class EscuderiaIdeasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuderiaIdeasApplication.class, args);
	}

}
