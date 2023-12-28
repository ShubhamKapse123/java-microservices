package com.hospital.hospitalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hospital service API");
		SpringApplication.run(HospitalServiceApplication.class, args);
	}

}
