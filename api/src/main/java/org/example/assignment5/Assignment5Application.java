package org.example.assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Assignment5Application {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(Assignment5Application.class, args);
	}

}
