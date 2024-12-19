package com.wagner.europace.bowling_game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingGameApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BowlingGameApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE); // no need to provide webserver here for cli app
		app.run(args);
	}
}
