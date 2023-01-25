package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Zahra.Taheri on 1/22/2023.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Transactional
    public void save(Student student) {
        Optional<Student> existEmail = studentRepository.findByEmail(student.getEmail());
        if (existEmail.isPresent()) {
            throw new IllegalStateException("Email Duplicate!");
        }
        studentRepository.save(student);
    }

    @Transactional
    public void edit(Long studentId, String fullName, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with " + studentId + " does not exist"));

        if (fullName != null
                && fullName.length() > 0
                && !Objects.equals(student.getFullName(), fullName)) {
            student.setFullName(fullName);
        }
        if (email != null
                && email.length() > 0
                && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken!");
            }
            student.setEmail(email);
        }
        studentRepository.save(student);
    }

    @Transactional
    public void delete(Student student) {
        Boolean existStudent = studentRepository.existsById(student.getId());
        if (!existStudent) {
            throw new IllegalStateException("Student with " + student.getId() + " is not exist");
        }
        studentRepository.delete(student);
    }

    @Transactional
    public void deleteById(Long studentId) {
        Boolean existStudent = studentRepository.existsById(studentId);
        if (!existStudent) {
            throw new IllegalStateException("Student with " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
