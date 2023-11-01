package com.second.pract.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Sections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sectionName;
    private String classTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String section_name) {
        this.sectionName = section_name;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String class_time) {
        this.classTime = class_time;
    }

    public Sections(String sectionName, String classTime) {
        this.sectionName = sectionName;
        this.classTime = classTime;
    }

    public Sections() {
    }
}
