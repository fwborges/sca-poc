package com.br.employee.api.gateway.repository.impl;

import com.br.employee.api.db.model.DepartamentModel;
import com.br.employee.api.db.model.EmployeeModel;
import com.br.employee.api.db.repository.EmployeeRepository;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepoGatewayImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeRepoGateway employeeRepoGateway;

    @Before
    public void setUp() {

        employeeRepoGateway = new EmployeeRepoGatewayImpl(employeeRepository);
    }

    @Test
    public void shouldSaveEmployee() {

        Employee employee = buildEmployeeEntity("Nome", "email@meuemail.com.br", Departament.MOBILE);

        employeeRepoGateway.saveNewEmployee(employee);

        verify(employeeRepository, times(1)).save(any());
        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    public void shouldDeleteEmployee() {

        employeeRepoGateway.deleteByEmail("email@meuemail.com.br");

        verify(employeeRepository, times(1)).deleteByEmail("email@meuemail.com.br");
    }

    @Test
    public void shouldFindEmployeeByEmail() {

        Optional<EmployeeModel> optionalEmployee = Optional.of(buildEmployeeModel("Nome", "email@meuemail.com.br", DepartamentModel.DEVELOPMENT));

        when(employeeRepository.findByEmail("email@meuemail.com.br")).thenReturn(optionalEmployee);

        Optional<Employee> employee = employeeRepoGateway.findByEmail("email@meuemail.com.br");

        assertTrue(employee.isPresent());
        assertEquals("email@meuemail.com.br", employee.get().getEmail());
    }

    @Test
    public void shouldNotFindEmployeeByEmail() {

        when(employeeRepository.findByEmail("email@meuemail.com.br")).thenReturn(Optional.empty());

        Optional<Employee> employee = employeeRepoGateway.findByEmail("email@meuemail.com.br");

        assertFalse(employee.isPresent());
    }

    @Test
    public void shouldFindAllEmployees() {

        when(employeeRepository.findAll()).thenReturn(buildEmployessModelWithDifferentDepartament());

        List<Employee> employees = employeeRepoGateway.findAll();

        assertEquals(3, employees.size());
    }

    @Test
    public void shouldFindAllEmployeesByDepartament() {

        when(employeeRepository.findByDepartament(DepartamentModel.CUSTOMER_SUPPORT))
                               .thenReturn(buildEmployessModelWithSameDepartament());

        List<Employee> employees = employeeRepoGateway.findByDepartament(Departament.CUSTOMER_SUPPORT);

        assertEquals(3, employees.size());
        assertEquals(Departament.CUSTOMER_SUPPORT, employees.get(0).getDepartament());
        assertEquals(Departament.CUSTOMER_SUPPORT, employees.get(1).getDepartament());
        assertEquals(Departament.CUSTOMER_SUPPORT, employees.get(2).getDepartament());
    }

    private EmployeeModel buildEmployeeModel(String name, String email, DepartamentModel departament) {

        return EmployeeModel.builder()
                .id(UUID.randomUUID().toString())
                .departament(departament)
                .name(name)
                .email(email)
                .build();
    }

    private Employee buildEmployeeEntity(String name, String email, Departament departament) {

        return Employee.builder()
                .id(UUID.randomUUID().toString())
                .departament(departament)
                .name(name)
                .email(email)
                .build();
    }

    private List<EmployeeModel> buildEmployessModelWithSameDepartament() {

        List<EmployeeModel> employees = new ArrayList<>();

        employees.add(buildEmployeeModel("meuemail@email.com.br", "Meu Nome", DepartamentModel.CUSTOMER_SUPPORT));
        employees.add(buildEmployeeModel("meuemail2@email.com.br", "Meu Nome Segundo", DepartamentModel.CUSTOMER_SUPPORT));
        employees.add(buildEmployeeModel("meuemail2@email.com.br", "Meu Nome Terceiro", DepartamentModel.CUSTOMER_SUPPORT));

        return  employees;
    }

    private List<EmployeeModel> buildEmployessModelWithDifferentDepartament() {

        List<EmployeeModel> employees = new ArrayList<>();

        employees.add(buildEmployeeModel("meuemail@email.com.br", "Meu Nome", DepartamentModel.ARCHITECTURE));
        employees.add(buildEmployeeModel("meuemail2@email.com.br", "Meu Nome Segundo", DepartamentModel.SALES));
        employees.add(buildEmployeeModel("meuemail2@email.com.br", "Meu Nome Terceiro", DepartamentModel.MOBILE));

        return  employees;
    }

}
