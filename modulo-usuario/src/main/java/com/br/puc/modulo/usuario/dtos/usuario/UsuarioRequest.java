package com.br.puc.modulo.usuario.dtos.usuario;

import lombok.Data;

@Data
public class UsuarioRequest {

    private String nome;

    private String login;

    private String senha;
}
