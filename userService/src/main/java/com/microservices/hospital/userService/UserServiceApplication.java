package com.microservices.hospital.userService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {
		System.out.println("main");
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
