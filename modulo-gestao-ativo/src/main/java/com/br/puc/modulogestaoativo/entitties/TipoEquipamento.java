package com.br.puc.modulogestaoativo.entitties;

public enum TipoEquipamento {

    CAMINHAO(3),
    TRITURADOR(6),
    ESTEIRA(12);

    private Integer mesesManutencao;

    TipoEquipamento(Integer mesesManutencao) {
        this.mesesManutencao = mesesManutencao;
    }

    public Integer getMesesManutencao() {
        return mesesManutencao;
    }
}
