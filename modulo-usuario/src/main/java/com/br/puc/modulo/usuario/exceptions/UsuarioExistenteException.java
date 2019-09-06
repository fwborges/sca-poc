package com.br.puc.modulo.usuario.exceptions;

public class UsuarioExistenteException extends RuntimeException {

    public UsuarioExistenteException(String mensagem) {
        super(mensagem);
    }
}
