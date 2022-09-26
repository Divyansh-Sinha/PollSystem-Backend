package com.fullstack.pollsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class PollsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollsystemApplication.class, args);
	}

}
