package com.example.ManyToMany.repo;

import com.example.ManyToMany.models.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Long> {
    School findByName(String name);
}
