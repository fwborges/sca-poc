package com.br.employee.api.employee.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeRequest {

    @NotNull
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull
    @NotEmpty(message = "Email is required")
    private String email;

    @NotNull
    @NotEmpty(message = "Departament is required")
    private String departament;
}
