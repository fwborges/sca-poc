package com.br.employee.api.usecase.employee;

import com.br.employee.api.gateway.repository.EmployeeRepoGateway;
import com.br.employee.api.usecase.employee.entities.Departament;
import com.br.employee.api.usecase.employee.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetListOfAllEmployeesTest {

    @Mock
    private EmployeeRepoGateway employeeRepoGateway;

    private GetListOfAllEmployees getListOfAllEmployees;

    @Before
    public void setUp() {

        getListOfAllEmployees = new GetListOfAllEmployees(employeeRepoGateway);
    }

    @Test
    public void shouldGetListOfAllEmployees() {

        when(employeeRepoGateway.findAll()).thenReturn(buildEmployess());

        List<Employee> employees = getListOfAllEmployees.execute();

        assertEquals(3, employees.size());
    }

    private List<Employee> buildEmployess() {

        List<Employee> employees = new ArrayList<>();

        employees.add(buildEmployee("meuemail@email.com.br", "Meu Nome", Departament.ARCHITECTURE));
        employees.add(buildEmployee("meuemail2@email.com.br", "Meu Nome Segundo", Departament.SALES));
        employees.add(buildEmployee("meuemail2@email.com.br", "Meu Nome Terceiro", Departament.MOBILE));

        return  employees;
    }

    private Employee buildEmployee(String email, String name, Departament departament) {

        return Employee.builder()
                .id(UUID.randomUUID().toString())
                .email(email)
                .departament(departament)
                .name(name)
                .build();
    }
}
