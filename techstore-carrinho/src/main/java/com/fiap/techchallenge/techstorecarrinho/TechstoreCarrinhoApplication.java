package com.fiap.techchallenge.techstorecarrinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechstoreCarrinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechstoreCarrinhoApplication.class, args);
	}

}
