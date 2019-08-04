package com.br.employee.api.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    @Id
    private String id;

    private String name;

    private String email;

    private DepartamentModel departament;
}
