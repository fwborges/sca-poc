package com.br.puc.modulo.usuario.controllers;

import com.br.puc.modulo.usuario.dtos.login.LoginRequest;
import com.br.puc.modulo.usuario.dtos.login.LoginResponse;
import com.br.puc.modulo.usuario.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService service;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        log.info("Recebendo requisição de autenticação pelo serviço" + appName + "de porta: " + portNumber);

        LoginResponse response = service.login(loginRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
