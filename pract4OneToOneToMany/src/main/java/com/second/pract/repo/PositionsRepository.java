package com.second.pract.repo;

import com.second.pract.models.Employees;
import com.second.pract.models.Positions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionsRepository extends CrudRepository<Positions, Long> {
    List<Positions> findByPositionName(String name);
}
