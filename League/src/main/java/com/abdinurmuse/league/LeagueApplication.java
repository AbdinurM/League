package com.abdinurmuse.league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

		//(exclude = { SecurityAutoConfiguration.class })
public class LeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueApplication.class, args);
	}

}
