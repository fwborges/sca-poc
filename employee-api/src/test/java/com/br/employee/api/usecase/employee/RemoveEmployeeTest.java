package com.br.employee.api.usecase.employee;

import com.br.employee.api.common.exception.EmployeeNotFoundException;
import com.br.employee.api.usecase.employee.entities.Employee;
import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RemoveEmployeeTest {

    @Mock
    private EmployeeRepoGateway employeeRepoGateway;

    private RemoveEmployee removeEmployee;

    @Before
    public void setUp() {

        removeEmployee = new RemoveEmployee(employeeRepoGateway);
    }

    @Test
    public void shouldRemoveEmployee() {

        when(employeeRepoGateway.findByEmail("meuemail@email.com")).thenReturn(Optional.of(buildEmployee()));

        removeEmployee.execute("meuemail@email.com");
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void shouldFailWhenTryRemoveEmployeeThatDoesNotExists() {

        when(employeeRepoGateway.findByEmail("meuemail@email.com")).thenReturn(Optional.empty());

        removeEmployee.execute("meuemail@email.com");
    }

    private Employee buildEmployee() {

        Employee employeeInput = new Employee();
        employeeInput.setName("Meu nome");
        employeeInput.setEmail("meuemail@email.com");
        employeeInput.setDepartament("Meu departamento");
        return employeeInput;
    }
}
