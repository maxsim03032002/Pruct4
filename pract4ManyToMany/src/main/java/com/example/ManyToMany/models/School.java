package com.example.ManyToMany.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name="student_school",
            joinColumns=@JoinColumn(name="school_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
