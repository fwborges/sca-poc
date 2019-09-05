package com.br.puc.modulosegurancacomunicacao.dtos;

import lombok.Data;

@Data
public class SensorResponse {

    private String medida;

    private Integer valor;

    private String dataOcorrencia;
}
