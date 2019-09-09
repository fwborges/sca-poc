package com.br.puc.modulosegurancacomunicacao.exceptions;

public class SensorDesconectadoException extends RuntimeException {
    public SensorDesconectadoException(String mensagem) {
        super(mensagem);
    }
}
