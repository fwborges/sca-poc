package com.br.employee.api.controller;

import com.br.employee.api.employee.CreateEmployee;
import com.br.employee.api.employee.GetListOfEmployee;
import com.br.employee.api.employee.RemoveEmployee;
import com.br.employee.api.employee.dto.EmployeeRequest;
import com.br.employee.api.employee.dto.EmployeeResponse;
import com.br.employee.api.employee.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "controller")
public class EmployeeController {

    @Autowired
    private CreateEmployee createEmployee;

    @Autowired
    private GetListOfEmployee getListOfEmployee;

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

        List<Employee> employees = getListOfEmployee.execute();

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
