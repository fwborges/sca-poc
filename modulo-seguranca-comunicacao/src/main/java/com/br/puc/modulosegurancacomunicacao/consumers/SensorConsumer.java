package com.br.puc.modulosegurancacomunicacao.consumers;

import com.br.puc.modulosegurancacomunicacao.entities.LeituraSensor;
import com.br.puc.modulosegurancacomunicacao.services.SensorService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Slf4j
public class SensorConsumer {

    private ModelMapper mapper;

    private SensorService service;

    @Autowired
    public SensorConsumer(ModelMapper mapper, SensorService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @JmsListener(destination = "sensor.queue")
    public void lerMensagemSensor(String mensagem) {

        Gson gson = new Gson();
        LeituraSensor leituraSensor = gson.fromJson(mensagem, LeituraSensor.class);
        leituraSensor.setDataOcorrencia(LocalDateTime.now());
        service.salvarLeitura(leituraSensor);
    }
}
