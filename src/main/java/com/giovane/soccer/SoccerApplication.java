package com.giovane.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class SoccerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoccerApplication.class, args);
	}
}
