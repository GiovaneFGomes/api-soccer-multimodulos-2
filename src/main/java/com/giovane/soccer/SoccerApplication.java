package com.giovane.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation makes your Spring Boot application act as a Configuration Server
//@EnableConfigServer
@SpringBootApplication
public class SoccerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoccerApplication.class, args);
	}
}
