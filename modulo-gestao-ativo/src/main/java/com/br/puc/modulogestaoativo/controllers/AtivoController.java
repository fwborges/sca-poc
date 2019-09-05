package com.br.puc.modulogestaoativo.controllers;

import com.br.puc.modulogestaoativo.dtos.AtivoRequest;
import com.br.puc.modulogestaoativo.dtos.AtivoResponse;
import com.br.puc.modulogestaoativo.services.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ativo")
public class AtivoController {

    @Autowired
    private AtivoService service;

    @PostMapping("criar")
    public ResponseEntity<Void> criar(@RequestBody AtivoRequest request) {

        service.criar(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("listar")
    public ResponseEntity<List<AtivoResponse>> listarTodos() {

        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

}
