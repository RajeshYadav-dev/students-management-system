package com.devji.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devji.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
  public Optional<Student> findByEmail(String email);
}
