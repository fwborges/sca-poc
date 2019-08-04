package com.br.employee.api.employee;

import com.br.employee.api.common.config.UseCase;
import com.br.employee.api.common.exception.EmployeeAlreadyExistsException;
import com.br.employee.api.common.exception.InvalidEmailException;
import com.br.employee.api.employee.entities.Employee;
import com.br.employee.api.gateway.client.EmailValidatorGateway;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UseCase
public class CreateEmployee {

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
            throw new InvalidEmailException("Cannot create employee with invalid email");
        }
    }

    private void checkExistingEmail(Employee employeeRequest) {

        Optional<Employee> employee = employeeRepoGateway.findByEmail(employeeRequest.getEmail());

        employee.ifPresent(emp -> {
            throw new EmployeeAlreadyExistsException("Cannot create employee, this email is already used");
        });
    }
}
