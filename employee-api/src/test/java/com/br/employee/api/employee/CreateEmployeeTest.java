package com.br.employee.api.employee;

import com.br.employee.api.common.exception.EmployeeAlreadyExistsException;
import com.br.employee.api.common.exception.InvalidEmailException;
import com.br.employee.api.employee.entities.Employee;
import com.br.employee.api.gateway.client.EmailValidatorGateway;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateEmployeeTest {

    @Mock
    private EmailValidatorGateway emailValidatorGateway;

    @Mock
    private EmployeeRepoGateway employeeRepoGateway;

    private CreateEmployee createEmployee;

    @Before
    public void setUp() {

        createEmployee = new CreateEmployee(employeeRepoGateway, emailValidatorGateway);
    }

    @Test
    public void shouldCreateEmployee() {

        Employee employeeInput = buildEmployee();
        createEmployee.execute(employeeInput);
    }

    @Test(expected = EmployeeAlreadyExistsException.class)
    public void shouldFailOnCreatingEmployeeWhenTryInsertWithExistingEmail() {

        Employee employeeInput = buildEmployee();

        when(employeeRepoGateway.findByEmail("meuemail@email.com")).thenReturn(Optional.of(buildEmployee()));

        createEmployee.execute(employeeInput);
    }

    @Test(expected = InvalidEmailException.class)
    public void shouldFailOnCreateingEmployeeWhenTryInsertWithInvalidEmail() {

        Employee employeeInput = buildEmployee();

        when(emailValidatorGateway.isInvalidEmail("meuemail@email.com")).thenReturn(Boolean.TRUE);

        createEmployee.execute(employeeInput);
    }

    private Employee buildEmployee() {

        Employee employeeInput = new Employee();
        employeeInput.setName("Meu nome");
        employeeInput.setEmail("meuemail@email.com");
        employeeInput.setDepartament("Meu departamento");
        return employeeInput;
    }
}
