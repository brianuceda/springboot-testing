package com.brianuceda.springboot_testing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestingApplication.class, args);
		// System.out.println("Hello after Spring Boot Application starts");
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			// System.out.println("Hello before Spring Boot Application starts");
		};
	}
}
