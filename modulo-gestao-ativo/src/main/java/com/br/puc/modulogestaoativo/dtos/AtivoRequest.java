package com.br.puc.modulogestaoativo.dtos;

import lombok.Data;

@Data
public class AtivoRequest {

    private String tipoEquipamento;

    private String modeloEquipamento;

    private Integer anoFabricacao;

    private String descricao;

}
