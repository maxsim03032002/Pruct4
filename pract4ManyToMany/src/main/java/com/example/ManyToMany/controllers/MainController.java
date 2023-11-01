package com.example.ManyToMany.controllers;

import com.example.ManyToMany.models.Student;
import com.example.ManyToMany.models.School;
import com.example.ManyToMany.repo.StudentRepository;
import com.example.ManyToMany.repo.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/student")
    private String Main(Model model){
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("student", students);
        Iterable<School> schools = schoolRepository.findAll();
        model.addAttribute("school", schools);
        return "student";
    }

    @PostMapping("/student/add")
    public String blogPostAdd(@RequestParam String student, @RequestParam String school, Model model)
    {
        Student student1 = studentRepository.findByName(student);
        School school1 = schoolRepository.findByName(school);
        student1.getSchools().add(school1);
        school1.getStudents().add(student1);
        studentRepository.save(student1);
        schoolRepository.save(school1);
        return "student";
    }
}
