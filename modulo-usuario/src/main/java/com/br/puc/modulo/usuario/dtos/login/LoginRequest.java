package com.br.puc.modulo.usuario.dtos.login;

import lombok.Data;

@Data
public class LoginRequest {

    private String login;

    private String senha;
}
