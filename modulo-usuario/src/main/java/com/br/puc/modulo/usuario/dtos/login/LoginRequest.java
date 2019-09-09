package com.br.puc.modulo.usuario.dtos.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotNull
    @NotEmpty(message = "Login é obrigatório")
    private String login;

    @NotNull
    @NotEmpty(message = "Senha é obrigatória")
    private String senha;
}
