package com.br.employee.api.usecase.employee;

import com.br.employee.api.common.config.UseCase;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import com.br.employee.api.usecase.employee.entities.Departament;
import com.br.employee.api.usecase.employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class GetListOfEmployeesByDepartament {

    private EmployeeRepoGateway employeeRepoGateway;

    @Autowired
    public GetListOfEmployeesByDepartament(EmployeeRepoGateway employeeRepoGateway) {
        this.employeeRepoGateway = employeeRepoGateway;
    }

    public List<Employee> execute(Departament departament) {

        return employeeRepoGateway.findByDepartament(departament);
    }
}
