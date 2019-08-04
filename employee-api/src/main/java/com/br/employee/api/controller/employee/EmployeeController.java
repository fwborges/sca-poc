package com.br.employee.api.controller.employee;

import com.br.employee.api.controller.employee.dto.DepartamentRequestOpt;
import com.br.employee.api.controller.employee.dto.EmployeeRequest;
import com.br.employee.api.controller.employee.dto.EmployeeResponse;
import com.br.employee.api.usecase.employee.CreateEmployee;
import com.br.employee.api.usecase.employee.GetListOfAllEmployees;
import com.br.employee.api.usecase.employee.GetListOfEmployeesByDepartament;
import com.br.employee.api.usecase.employee.RemoveEmployee;
import com.br.employee.api.usecase.employee.entities.Departament;
import com.br.employee.api.usecase.employee.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "employee")
public class EmployeeController {

    @Autowired
    private CreateEmployee createEmployee;

    @Autowired
    private GetListOfAllEmployees getListOfAllEmployees;

    @Autowired
    private GetListOfEmployeesByDepartament getListOfEmployeesByDepartament;

    @Autowired
    private RemoveEmployee removeEmployee;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("save-new")
    public ResponseEntity<Void> saveNewEmployee(@RequestBody @Valid EmployeeRequest request) {

        createEmployee.execute(mapper.map(request, Employee.class));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("list-all")
    public List<EmployeeResponse> getAllEmployees() {

        List<Employee> employees = getListOfAllEmployees.execute();

        return employees
                .stream()
                .map(employee -> mapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("list-by-departament")
    public List<EmployeeResponse> getAllEmployessByDepartament(@RequestParam DepartamentRequestOpt departament) {

        List<Employee> employees = getListOfEmployeesByDepartament.execute(Departament.valueOf(departament.name()));

        return employees
                .stream()
                .map(employee -> mapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("{email}/remove")
    public ResponseEntity<Void> removeEmployee(@PathVariable String email) {

        removeEmployee.execute(email);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
