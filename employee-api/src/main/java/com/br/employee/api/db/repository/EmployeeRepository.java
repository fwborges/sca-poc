package com.br.employee.api.db.repository;

import com.br.employee.api.db.model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, String> {

    List<EmployeeModel> findAll();

    Optional<EmployeeModel> findByEmail(String email);

    void deleteByEmail(String email);
}
