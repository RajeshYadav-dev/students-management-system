package com.devji.student.mapper;

import com.devji.student.datatransferobject.StudentDTO;
import com.devji.student.entity.Student;

public class StudentMapper {
  public static StudentDTO StudentToStudentDTO(Student student) {
    return new StudentDTO(
        student.getId(),
        student.getFirstName(),
        student.getLastName(),
        student.getCity(),
        student.getEmail(),
        student.getGender(),
        student.getDob(),
        student.getCreatedAt(),
        student.getUpdatedAt());
  }

  public static Student StudentDTOToStudent(StudentDTO studentDTO) {
    return new Student(
        studentDTO.getId(),
        studentDTO.getFirstName(),
        studentDTO.getLastName(),
        studentDTO.getCity(),
        studentDTO.getEmail(),
        studentDTO.getGender(),
        studentDTO.getDob(),
        studentDTO.getCreatedAt(),
        studentDTO.getUpdatedAt());
  }
}
