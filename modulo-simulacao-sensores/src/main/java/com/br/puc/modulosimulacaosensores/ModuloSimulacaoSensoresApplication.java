package com.br.puc.modulosimulacaosensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class ModuloSimulacaoSensoresApplication implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ModuloSimulacaoSensoresApplication.class, args);
	}

	private void simular() {

		Random random = new Random();

		jmsTemplate.convertAndSend("sensor.queue", "{medida: 'Deslocamento', valor: " + random.nextInt(10) + "}");
		jmsTemplate.convertAndSend("sensor.queue", "{medida: 'Sismo', valor: " + random.nextInt(10) + "}");
	}

	@Override
	public void run(String... args) throws Exception {

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override public void run() {
				System.out.println("Executando simulacao...");
				simular();
			}

		}, 1000, 15000);


	}
}
