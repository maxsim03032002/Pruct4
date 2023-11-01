package com.second.pract.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionName;
    @OneToMany(mappedBy = "positions", fetch = FetchType.EAGER)
    private Collection<Employees> employeesCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String position_name) {
        this.positionName = position_name;
    }

    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Positions(String positionName, Collection<Employees> employeesCollection) {
        this.positionName = positionName;
        this.employeesCollection = employeesCollection;
    }

    public Positions() {
    }
}
