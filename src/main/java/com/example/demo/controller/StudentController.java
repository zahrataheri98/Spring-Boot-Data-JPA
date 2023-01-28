package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Zahra.Taheri on 1/22/2023.
 */
@RestController
@RequestMapping(path = "/sc")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    http://localhost:8080/sc/getAll
    @RequestMapping(path = "/getAll")
    public List<Student> getAllStudent(@ModelAttribute Student student) {
        return studentService.getAllStudent();
    }

//    http://localhost:8080/sc/save?fullName=neda&age=25&email=nedaaaa@gmail.com
    @RequestMapping(path = "/save")
    public void save(@ModelAttribute Student student) {
        studentService.save(student);
    }

//    http://localhost:8080/sc/edite?id=63&fullName=zahra&email=taheri@gmail.com
    @RequestMapping(path = "/edite")
    public void edite(@ModelAttribute Student student) {
        studentService.edit(student.getId(), student.getFullName(), student.getEmail());
    }

//    http://localhost:8080/sc/delete?id=82
    @RequestMapping(path = "/delete")
    public void deleteById(@ModelAttribute Student student) {
        studentService.deleteById(student.getId());
    }

//    http://localhost:8080/sc/delete/83
    @RequestMapping(path = "delete/{studentId}")
    public void deleteByIdVal(@PathVariable("studentId") Long id) {
        studentService.deleteById(id);
    }

}
