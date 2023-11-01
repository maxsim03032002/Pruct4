package com.example.ManyToMany.repo;

import com.example.ManyToMany.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByName(String name);
}
