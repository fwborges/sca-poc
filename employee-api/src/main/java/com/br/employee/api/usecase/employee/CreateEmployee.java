package com.br.employee.api.usecase.employee;

import com.br.employee.api.common.config.UseCase;
import com.br.employee.api.common.exception.EmployeeAlreadyExistsException;
import com.br.employee.api.common.exception.InvalidEmailException;
import com.br.employee.api.usecase.employee.entities.Employee;
import com.br.employee.api.gateway.client.EmailValidatorGateway;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UseCase
public class CreateEmployee {

    private static Logger LOGGER = LoggerFactory.getLogger(CreateEmployee.class);

    private EmployeeRepoGateway employeeRepoGateway;

    private EmailValidatorGateway emailValidatorGateway;

    @Autowired
    public CreateEmployee(EmployeeRepoGateway employeeRepoGateway, EmailValidatorGateway emailValidatorGateway) {

        this.employeeRepoGateway = employeeRepoGateway;
        this.emailValidatorGateway = emailValidatorGateway;
    }

    public void execute(Employee employeeInput) {

        validateBeforeCreate(employeeInput);

        employeeRepoGateway.saveNewEmployee(employeeInput);
    }

    private void validateBeforeCreate(Employee employeeRequest) {

        checkExistingEmail(employeeRequest);
        checkIfInvalidEmail(employeeRequest);
    }

    private void checkIfInvalidEmail(Employee employeeRequest) {

        if(emailValidatorGateway.isInvalidEmail(employeeRequest.getEmail())) {
            LOGGER.error("Cannot create employee with invalid email {} ", employeeRequest.getEmail());
            throw new InvalidEmailException("Cannot create employee with invalid email");
        }
    }

    private void checkExistingEmail(Employee employeeRequest) {

        Optional<Employee> employee = employeeRepoGateway.findByEmail(employeeRequest.getEmail());

        employee.ifPresent(emp -> {
            LOGGER.error("Cannot create employee, this email {} is already used ", employeeRequest.getEmail());
            throw new EmployeeAlreadyExistsException("Cannot create employee, this email is already used");
        });
    }
}
