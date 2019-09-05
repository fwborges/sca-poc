package com.br.puc.modulosegurancacomunicacao.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "leitura_sensor")
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medida;

    private Integer valor;

    private boolean transmitida;

    private LocalDateTime dataOcorrencia;
}
