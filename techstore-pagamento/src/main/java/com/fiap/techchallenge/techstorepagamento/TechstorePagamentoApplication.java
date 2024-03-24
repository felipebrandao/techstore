package com.fiap.techchallenge.techstorepagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechstorePagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechstorePagamentoApplication.class, args);
	}

}
