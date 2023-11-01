package com.second.pract.repo;

import com.second.pract.models.Employees;
import com.second.pract.models.Grades;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradesRepository extends CrudRepository<Grades, Long> {
    List<Grades> findByGradeName(String name);
}
