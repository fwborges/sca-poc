package com.br.puc.modulosegurancacomunicacao.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorResponse {

    private String medida;

    private Integer valor;

    private LocalDateTime dataOcorrencia;
}
