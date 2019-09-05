package com.br.puc.modulogestaoativo.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AtivoResponse {

    private Long id;

    private String tipoEquipamento;

    private String modeloEquipamento;

    private Integer anoFabricacao;

    private String descricao;

    private LocalDate proximaManutencaoPreventiva;

    private LocalDate proximaManutencaoCorretiva;
}
