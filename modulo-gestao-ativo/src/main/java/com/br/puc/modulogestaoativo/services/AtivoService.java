package com.br.puc.modulogestaoativo.services;

import com.br.puc.modulogestaoativo.dtos.AtivoRequest;
import com.br.puc.modulogestaoativo.dtos.AtivoResponse;
import com.br.puc.modulogestaoativo.entitties.Ativo;
import com.br.puc.modulogestaoativo.entitties.TipoEquipamento;
import com.br.puc.modulogestaoativo.repositories.AtivoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtivoService {

    private AtivoRepository repository;

    private ModelMapper mapper;

    public AtivoService(AtivoRepository repository, ModelMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public void criar(AtivoRequest request) {

        Ativo ativo = mapper.map(request, Ativo.class);

        TipoEquipamento tipoEquipamento = TipoEquipamento.valueOf(request.getTipoEquipamento().toUpperCase());
        ativo.setProximaManutencaoPreventiva(LocalDate.now().plusMonths(tipoEquipamento.getMesesManutencao()));

        repository.save(ativo);
    }

    public List<AtivoResponse> listarTodos() {

        List<Ativo> ativos = repository.findAll();

        return ativos.stream()
                .map(ativo -> mapper.map(ativo, AtivoResponse.class))
                .collect(Collectors.toList());
    }
}
