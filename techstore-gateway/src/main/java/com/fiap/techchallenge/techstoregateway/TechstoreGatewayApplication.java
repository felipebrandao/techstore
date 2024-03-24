package com.fiap.techchallenge.techstoregateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechstoreGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechstoreGatewayApplication.class, args);
	}

}
