package com.second.pract.repo;

import com.second.pract.models.Employees;
import com.second.pract.models.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Students, Long> {
    List<Students> findBySurname(String surname);
}