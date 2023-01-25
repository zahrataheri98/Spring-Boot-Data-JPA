package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping(path = "{studentId}")
    public void edit(@PathVariable("studentId") Long studentId,
                     @RequestParam(required = false) String fullName,
                     @RequestParam(required = false) String email) {
        studentService.edit(studentId, fullName, email);
    }

    @DeleteMapping
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteById(@PathVariable("studentId") Long studentId) {
        studentService.deleteById(studentId);
    }

}
