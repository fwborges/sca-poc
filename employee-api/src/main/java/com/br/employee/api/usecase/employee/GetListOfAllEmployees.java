package com.br.employee.api.usecase.employee;

import com.br.employee.api.common.config.UseCase;
import com.br.employee.api.usecase.employee.entities.Employee;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class GetListOfAllEmployees {

    private EmployeeRepoGateway employeeRepoGateway;

    @Autowired
    public GetListOfAllEmployees(EmployeeRepoGateway employeeRepoGateway) {

        this.employeeRepoGateway = employeeRepoGateway;
    }

    public List<Employee> execute() {

        return employeeRepoGateway.findAll();
    }
}
