package com.devji.student.services;

import java.util.List;

import com.devji.student.datatransferobject.StudentDTO;

public interface StudentServices {

  public StudentDTO addStudent(StudentDTO studentDTO);

  public List<StudentDTO> getAllStudent();

  public StudentDTO getStudentById(Long id);

  public StudentDTO updateStudent(Long id, StudentDTO studentDTO);

  public String deleteStudent(Long id);

  public StudentDTO getStudentByEmail(String email);

}