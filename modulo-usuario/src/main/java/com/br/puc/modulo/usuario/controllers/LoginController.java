package com.br.puc.modulo.usuario.controllers;

import com.br.puc.modulo.usuario.dtos.login.LoginRequest;
import com.br.puc.modulo.usuario.dtos.login.LoginResponse;
import com.br.puc.modulo.usuario.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        LoginResponse response = service.login(loginRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
