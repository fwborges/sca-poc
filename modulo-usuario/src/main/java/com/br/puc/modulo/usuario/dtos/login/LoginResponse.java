package com.br.puc.modulo.usuario.dtos.login;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String token;
}
