package com.br.employee.api.controller.employee.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeRequest {

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @NotNull
    @NotEmpty(message = "Email é obrigatório")
    private String email;

    @NotNull
    @NotEmpty(message = "Senha é obrigatória")
    private String password;
}
