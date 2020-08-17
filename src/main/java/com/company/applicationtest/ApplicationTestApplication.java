package com.company.applicationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ApplicationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTestApplication.class, args);
	}

}
