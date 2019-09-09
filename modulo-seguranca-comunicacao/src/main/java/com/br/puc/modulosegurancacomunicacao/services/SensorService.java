package com.br.puc.modulosegurancacomunicacao.services;

import com.br.puc.modulosegurancacomunicacao.dtos.SensorResponse;
import com.br.puc.modulosegurancacomunicacao.entities.LeituraSensor;
import com.br.puc.modulosegurancacomunicacao.exceptions.SensorDesconectadoException;
import com.br.puc.modulosegurancacomunicacao.repositories.SensorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private SensorRepository repository;

    private ModelMapper mapper;

    @Autowired
    public SensorService(SensorRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void salvarLeitura(LeituraSensor leituraSensor) {

        repository.save(leituraSensor);
    }

    public List<SensorResponse> lerUltimoRegistroSensor() {

        List<LeituraSensor> leituraSensorList = repository.findFirst2ByMedidaInOrderByDataOcorrenciaDesc(Arrays.asList("Sismo", "Deslocamento"));

        List<SensorResponse> sensorResponses = leituraSensorList.stream()
                .map(leituraSensor -> {

                    SensorResponse map = mapper.map(leituraSensor, SensorResponse.class);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    map.setDataOcorrencia(leituraSensor.getDataOcorrencia().format(formatter));

                    return map;
                })
                .collect(Collectors.toList());

        checarLeitoresConectados(sensorResponses);

        return sensorResponses;
    }

    public void checarLeitoresConectados(List<SensorResponse> sensorResponses) {

        SensorResponse response = sensorResponses.get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime ultimaOcorrenciaRegistrada = LocalDateTime.from(formatter.parse(response.getDataOcorrencia()));

        if(ultimaOcorrenciaRegistrada.plusSeconds(22).isBefore(LocalDateTime.now())) {
            throw new SensorDesconectadoException("Não registros de leitura dos sensores, favor verificar");
        }

    }
}
