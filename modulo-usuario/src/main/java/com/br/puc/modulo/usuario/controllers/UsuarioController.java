package com.br.puc.modulo.usuario.controllers;

import com.br.puc.modulo.usuario.dtos.usuario.UsuarioRequest;
import com.br.puc.modulo.usuario.dtos.usuario.UsuarioResponse;
import com.br.puc.modulo.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("criar")
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        UsuarioResponse response = service.criarUsuario(usuarioRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
