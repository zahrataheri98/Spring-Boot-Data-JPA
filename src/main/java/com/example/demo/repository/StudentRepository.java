package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Zahra.Taheri on 1/22/2023.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select s from student s where s.email = :email")
    Optional<Student> findByEmail(@Param("email") String studentEmail);

}
