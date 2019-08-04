package com.br.employee.api.gateway.repository;

import com.br.employee.api.usecase.employee.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepoGateway {

    void saveNewEmployee(Employee employee);

    void deleteByEmail(String email);

    Optional<Employee> findByEmail(String email);

    List<Employee> findAll();
}
