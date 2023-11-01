package com.second.pract.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gradeName;
    @OneToOne(optional = false, mappedBy = "grades")
    private Students students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String grade_name) {
        this.gradeName = grade_name;
    }

    public Grades(String gradeName) {
        this.gradeName = gradeName;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Grades(String gradeName, Students students) {
        this.gradeName = gradeName;
        this.students = students;
    }

    public Grades() {
    }
}
