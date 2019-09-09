package com.br.puc.modulo.usuario.dtos.usuario;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioRequest {

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotNull
    @NotEmpty(message = "Login é obrigatório")
    private String login;

    @NotNull
    @NotEmpty(message = "Senha é obrigatório")
    private String senha;
}
