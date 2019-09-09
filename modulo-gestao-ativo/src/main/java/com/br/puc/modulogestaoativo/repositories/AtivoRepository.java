package com.br.puc.modulogestaoativo.repositories;

import com.br.puc.modulogestaoativo.entitties.Ativo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtivoRepository extends CrudRepository<Ativo, Long> {

    List<Ativo> findAll();
}
