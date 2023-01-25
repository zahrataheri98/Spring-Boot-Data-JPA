package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Zahra.Taheri on 1/22/2023.
 */
@Entity(name = "student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email")

        })
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false    )
    private Long id;

    @Column(
            name = "fullName",
            columnDefinition = "varchar2(20)"
    )
    private String fullName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "varchar2(20)",
            unique = true
    )
    private String email;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "age")
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String fullName, String email, LocalDate dob, Integer age) {
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
