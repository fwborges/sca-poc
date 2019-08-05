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
public class GetListOfEmployeesByDepartamentTest {

    @Mock
    private EmployeeRepoGateway employeeRepoGateway;

    private GetListOfEmployeesByDepartament getListOfEmployeesByDepartament;

    @Before
    public void setUp() {

        getListOfEmployeesByDepartament = new GetListOfEmployeesByDepartament(employeeRepoGateway);
    }

    @Test
    public void shouldGetListOfAllEmployees() {

        when(employeeRepoGateway.findByDepartament(Departament.ARCHITECTURE)).thenReturn(buildEmployess());

        List<Employee> employees = getListOfEmployeesByDepartament.execute(Departament.ARCHITECTURE);

        assertEquals(2, employees.size());
        assertEquals(Departament.ARCHITECTURE, employees.get(0).getDepartament());
        assertEquals(Departament.ARCHITECTURE, employees.get(1).getDepartament());
    }

    private List<Employee> buildEmployess() {

        List<Employee> employees = new ArrayList<>();

        employees.add(buildEmployee("meuemail@email.com.br", "Meu Nome", Departament.ARCHITECTURE));
        employees.add(buildEmployee("meuemail2@email.com.br", "Meu Nome Segundo", Departament.ARCHITECTURE));

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
