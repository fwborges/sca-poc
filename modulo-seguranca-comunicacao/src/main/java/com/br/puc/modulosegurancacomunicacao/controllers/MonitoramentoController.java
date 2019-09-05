package com.br.puc.modulosegurancacomunicacao.controllers;

import com.br.puc.modulosegurancacomunicacao.dtos.SensorResponse;
import com.br.puc.modulosegurancacomunicacao.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/monitoramento")
public class MonitoramentoController {

    private SensorService service;

    @Autowired
    public MonitoramentoController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/sensores/mensagens/listar")
    public ResponseEntity<List<SensorResponse>> recuperarUltimasMensagensSensores() {

        List<SensorResponse> sensorResponses = service.lerUltimoRegistroSensor();

        return new ResponseEntity<>(sensorResponses, HttpStatus.OK);
    }

    @PostMapping("/alarme/disparar")
    public ResponseEntity<Void> dispararAlarme() {

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
