package com.challenge.arturoIsidro.app.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioEmailApplication.class, args);
	}

}
