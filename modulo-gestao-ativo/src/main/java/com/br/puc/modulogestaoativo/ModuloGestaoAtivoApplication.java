package com.br.puc.modulogestaoativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ModuloGestaoAtivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloGestaoAtivoApplication.class, args);
	}

}
