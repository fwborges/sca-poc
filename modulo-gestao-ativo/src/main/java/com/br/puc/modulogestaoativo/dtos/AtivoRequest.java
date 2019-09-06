package com.br.puc.modulogestaoativo.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AtivoRequest {

    @NotNull
    @NotEmpty(message = "Tipo de equipamento é obrigatório")
    private String tipoEquipamento;

    @NotNull
    @NotEmpty(message = "Modelo de equipamentoé obrigatório")
    private String modeloEquipamento;

    @NotNull(message = "Ano de fabricação é obrigatório")
    private Integer anoFabricacao;

    @NotNull
    @NotEmpty(message = "Descrição é obrigatório")
    private String descricao;

}
