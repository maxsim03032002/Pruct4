package com.second.pract.repo;

import com.second.pract.models.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesRepository extends CrudRepository<Employees, Long> {
    List<Employees> findBySurname(String surname);
}
