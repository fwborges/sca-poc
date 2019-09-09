package com.br.puc.modulogestaoativo.entitties;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "ATIVO_SCA")
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_equipamento")
    private String tipoEquipamento;

    @Column(name = "modelo_equipamento")
    private String modeloEquipamento;

    @Column(name = "ano_fabricacao")
    private Integer anoFabricacao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "proxima_manutencao_preventiva")
    private LocalDate proximaManutencaoPreventiva;

    @Column(name = "proxima_manutencao_corretiva")
    private LocalDate proximaManutencaoCorretiva;
}
