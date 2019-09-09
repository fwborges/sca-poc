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

    @Column(name = "nome_medida")
    private String medida;

    @Column(name = "valor_medida")
    private Integer valor;

    @Column(name = "data_ocorrencia")
    private LocalDateTime dataOcorrencia;
}
