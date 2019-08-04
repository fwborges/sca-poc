package com.br.employee.api.gateway.repository.impl;

import com.br.employee.api.db.model.EmployeeModel;
import com.br.employee.api.db.repository.EmployeeRepository;
import com.br.employee.api.employee.entities.Employee;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeRepoGatewayImpl implements EmployeeRepoGateway {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveNewEmployee(Employee employee) {

        EmployeeModel employeeModel = mapper.map(employee, EmployeeModel.class);

        repository.save(employeeModel);
    }

    @Override
    public void deleteByEmail(String email) {

        repository.deleteByEmail(email);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {

        Optional<EmployeeModel> employeeModel = repository.findByEmail(email);

        if(employeeModel.isPresent()) {
            return Optional.of(mapper.map(employeeModel.get(), Employee.class));
        }

        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {

        List<EmployeeModel> employeeModels = repository.findAll();

        return employeeModels
                .stream()
                .map(employee -> mapper.map(employee, Employee.class))
                .collect(Collectors.toList());
    }
}
