package com.second.pract.controllers;

import com.second.pract.models.Employees;
import com.second.pract.models.Grades;
import com.second.pract.models.Positions;
import com.second.pract.models.Sections;
import com.second.pract.models.Students;
import com.second.pract.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Controller
public class MainController {
    private final StudentsRepository studentsRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private GradesRepository gradesRepository;
    @Autowired
    private PositionsRepository positionsRepository;
    @Autowired
    private SectionsRepository sectionsRepository;

    public MainController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/school")
    public String schoolMain(Model model){
        Iterable<Students> students = studentsRepository.findAll();
        Iterable<Employees> employees = employeesRepository.findAll();
        Iterable<Grades> grades = gradesRepository.findAll();
        Iterable<Positions> positions = positionsRepository.findAll();
        Iterable<Sections> sections = sectionsRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("employees", employees);
        model.addAttribute("grades", grades);
        model.addAttribute("positions", positions);
        model.addAttribute("sections", sections);
        return "school-main";
    }

    @GetMapping("/school/addStudent")
    public String studentsAdd(Students students, Model model){
        Iterable<Grades> grades = gradesRepository.findAll();
        model.addAttribute("grades", grades);
        return "students-add";
    }
    @PostMapping("/school/addStudent")
    public String studentsPostAdd(@Valid Students students,
                                  @Valid Grades grades,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            return "students-add";
        }
        students.setGrades(grades);
        studentsRepository.save(students);
        return "redirect:/school";
    }
    @GetMapping("/school/students/{id}/remove")
    public String studentsRemove(@PathVariable Long id){
        studentsRepository.deleteById(id);
        return "redirect:/school";
    }
    @GetMapping("/school/students/{id}/edit")
    public String studentsEdit(@PathVariable Long id, Model model, Students students){
        model.addAttribute("students", studentsRepository.findById(id).orElseThrow());
        return "students-edit";
    }
    @PostMapping("/school/students/{id}/edit")
    public String studentsEdited(@PathVariable Long id,
                                 @Valid Students students,
                                 BindingResult bindingResult,
                                 Model model){
        if(bindingResult.hasErrors()){
            return "students-edit";
        }
        studentsRepository.save(students);
        return "redirect:/school";
    }

    @GetMapping("/school/addEmployees")
    public String employeesAdd(Employees employees, Model model){
        Iterable<Positions> positions = positionsRepository.findAll();
        model.addAttribute("positions", positions);
        return "employees-add";
    }
    @PostMapping("/school/addEmployees")
    public String employeesPostAdd(@Valid Employees employees, @Valid Positions positions, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employees-add";
        }
        employees.setPositions(positions);
        employeesRepository.save(employees);
        return "redirect:/school";
    }
    @GetMapping("/school/employees/{id}/remove")
    public String employeesRemove(@PathVariable Long id){
        employeesRepository.deleteById(id);
        return "redirect:/school";
    }
    @GetMapping("/school/employees/{id}/edit")
    public String employeesEdit(@PathVariable Long id, Model model, Employees employees){
        model.addAttribute("employees", employeesRepository.findById(id).orElseThrow());
        return "employees-edit";
    }
    @PostMapping("/school/employees/{id}/edit")
    public String employeesEdited(@PathVariable Long id,
                                 @Valid Employees employees,
                                 BindingResult bindingResult,
                                 Model model){
        if(bindingResult.hasErrors()){
            return "employees-edit";
        }
        employeesRepository.save(employees);
        return "redirect:/school";
    }


    /*@GetMapping("/school/addGrades")
    public String gradesAdd(Model model){
        return "grades-add";
    }
    @PostMapping("/school/addGrades")
    public String gradesPostAdd(@RequestParam String gradeName,
                                Model model){
        Grades post = new Grades(gradeName);
        gradesRepository.save(post);
        return "redirect:/school";
    } */

    @GetMapping("/school/addGrades")
    public String gradesAdd(Grades grades){
        return "grades-add";
    }
    @PostMapping("/school/addGrades")
    public String gradesPostAdd(@Valid Grades grades, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "grades-add";
        }
        gradesRepository.save(grades);
        return "redirect:/school";
    }
    @GetMapping("/school/grades/{id}/remove")
    public String gradesRemove(@PathVariable Long id){
        gradesRepository.deleteById(id);
        return "redirect:/school";
    }
    @GetMapping("/school/grades/{id}/edit")
    public String gradesEdit(@PathVariable Long id, Model model, Grades grades){
        model.addAttribute("grades", gradesRepository.findById(id).orElseThrow());
        return "grades-edit";
    }
    @PostMapping("/school/grades/{id}/edit")
    public String gradesEdited(@PathVariable Long id,
                               @RequestParam String gradeName,
                               Model model,
                               @Valid Grades grades,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //model.addAttribute("grade", gradesRepository.findById(id).orElseThrow());
            return "grades-edit";
        }
        Grades gradeEdited = gradesRepository.findById(id).orElseThrow();
        gradeEdited.setGradeName(gradeName);
        gradesRepository.save(gradeEdited);
        return "redirect:/school";
    }


    @GetMapping("/school/addPositions")
    public String positionsAdd(Positions positions){
        return "positions-add";
    }
    @PostMapping("/school/addPositions")
    public String positionsPostAdd(@Valid Positions positions, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "positions-add";
        }
        positionsRepository.save(positions);
        return "redirect:/school";
    }
    @GetMapping("/school/positions/{id}/remove")
    public String positionsRemove(@PathVariable Long id){
        positionsRepository.deleteById(id);
        return "redirect:/school";
    }
    @GetMapping("/school/positions/{id}/edit")
    public String positionsEdit(@PathVariable Long id, Model model, Positions positions){
        model.addAttribute("positions", positionsRepository.findById(id).orElseThrow());
        return "positions-edit";
    }
    @PostMapping("/school/positions/{id}/edit")
    public String positionsEdited(@PathVariable Long id,
                               @Valid Positions positions,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            return "positions-edit";
        }
        positionsRepository.save(positions);
        return "redirect:/school";
    }


    @GetMapping("/school/addSections")
    public String sectionsAdd(Sections sections){
        return "sections-add";
    }
    @PostMapping("/school/addSections")
    public String sectionsPostAdd(@Valid Sections sections,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            return "sections-add";
        }
        sectionsRepository.save(sections);
        return "redirect:/school";
    }
    @GetMapping("/school/sections/{id}/remove")
    public String sectionsRemove(@PathVariable Long id){
        sectionsRepository.deleteById(id);
        return "redirect:/school";
    }
    @GetMapping("/school/sections/{id}/edit")
    public String sectionsEdit(@PathVariable Long id, Sections sections, Model model){
        model.addAttribute("sections", sectionsRepository.findById(id).orElseThrow());
        return "sections-edit";
    }
    @PostMapping("/school/sections/{id}/edit")
    public String sectionsEdited(@PathVariable Long id,
                                 @Valid Sections sections,
                                 BindingResult bindingResult,
                                 Model model){
        if(bindingResult.hasErrors()){
            return "sections-edit";
        }
        sectionsRepository.save(sections);
        return "redirect:/school";
    }


    @GetMapping("/school/findEmployees")
    public String employeesFind(Model model){
        return "employees-find";
    }
    @PostMapping("/school/findEmployees")
    public String employeesFound(@RequestParam String surname, Model model){
        List<Employees> result = employeesRepository.findBySurname(surname);
        model.addAttribute("result", result);
        return "employees-find";
    }


    @GetMapping("/school/findGrades")
    public String gradesFind(Model model){
        return "grades-find";
    }
    @PostMapping("/school/findGrades")
    public String gradesFound(@RequestParam String name, Model model){
        List<Grades> result = gradesRepository.findByGradeName(name);
        model.addAttribute("result", result);
        return "grades-find";
    }


    @GetMapping("/school/findPositions")
    public String positionsFind(Model model){
        return "positions-find";
    }
    @PostMapping("/school/findPositions")
    public String positionsFound(@RequestParam String name, Model model){
        List<Positions> result = positionsRepository.findByPositionName(name);
        model.addAttribute("result", result);
        return "positions-find";
    }


    @GetMapping("/school/findSections")
    public String sectionsFind(Model model){
        return "sections-find";
    }
    @PostMapping("/school/findSections")
    public String sectionsFound(@RequestParam String name, Model model){
        List<Sections> result = sectionsRepository.findBySectionName(name);
        model.addAttribute("result", result);
        return "sections-find";
    }


    @GetMapping("/school/findStudents")
    public String studentsFind(Model model){
        return "students-find";
    }
    @PostMapping("/school/findStudents")
    public String studentsFound(@RequestParam String surname, Model model){
        List<Students> result = studentsRepository.findBySurname(surname);
        model.addAttribute("result", result);
        return "students-find";
    }
}