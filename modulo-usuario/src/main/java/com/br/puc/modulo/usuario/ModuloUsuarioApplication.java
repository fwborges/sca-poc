package com.br.puc.modulo.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ModuloUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloUsuarioApplication.class, args);
	}

}
