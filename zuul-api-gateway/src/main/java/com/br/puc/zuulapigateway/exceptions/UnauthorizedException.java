package com.br.puc.zuulapigateway.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String mensagem) {
        super(mensagem);
    }
}
