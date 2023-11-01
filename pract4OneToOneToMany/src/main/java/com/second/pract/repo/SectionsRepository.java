package com.second.pract.repo;

import com.second.pract.models.Employees;
import com.second.pract.models.Sections;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectionsRepository extends CrudRepository<Sections, Long> {
    List<Sections> findBySectionName(String name);
}
