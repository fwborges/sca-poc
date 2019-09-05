package com.br.puc.modulosegurancacomunicacao.repositories;

import com.br.puc.modulosegurancacomunicacao.entities.LeituraSensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends CrudRepository<LeituraSensor, Long> {

//    @Query(value = "SELECT msg From LeituraSensor msg WHERE msg.medida in ('sismo', 'deslocamento') order by msg.dataOcorrencia desc limit 2")
//    List<LeituraSensor> recuperarUltimasMensagens();

    List<LeituraSensor> findFirst2ByMedidaInOrderByDataOcorrenciaDesc(List<String> medida);
}
