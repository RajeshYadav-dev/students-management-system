package com.devji.student.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devji.student.datatransferobject.StudentDTO;
import com.devji.student.entity.Student;
import com.devji.student.exception.ResourceNotFoundException;
import com.devji.student.mapper.StudentMapper;
import com.devji.student.repository.StudentRepository;
import com.devji.student.services.StudentServices;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServicesImpl implements StudentServices {

  private final StudentRepository studentRepository;

  @Override
  public StudentDTO addStudent(StudentDTO studentDTO) {
    Student student = StudentMapper.StudentDTOToStudent(studentDTO);
    Student savedStudent = studentRepository.save(student);
    return StudentMapper.StudentToStudentDTO(savedStudent);
  }

  @Override
  public List<StudentDTO> getAllStudent() {
    List<Student> students = studentRepository.findAll();
    return students.stream().map((student -> StudentMapper.StudentToStudentDTO(student))).collect(Collectors.toList());
  }

  @Override
  public StudentDTO getStudentById(Long id) {
    Student student = studentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found with given id:" + id));
    return StudentMapper.StudentToStudentDTO(student);
  }

  @Override
  public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
    Student student = studentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found with given id:" + id));

    student.setFirstName(studentDTO.getFirstName());
    student.setLastName(studentDTO.getLastName());
    student.setCity(studentDTO.getCity());
    student.setEmail(studentDTO.getEmail());
    student.setGender(studentDTO.getGender());
    student.setDob(studentDTO.getDob());
    student.setCreatedAt(studentDTO.getCreatedAt());
    student.setUpdatedAt(studentDTO.getUpdatedAt());

    Student updatedStudent = studentRepository.save(student);
    return StudentMapper.StudentToStudentDTO(updatedStudent);
  }

  @Override
  public String deleteStudent(Long id) {
    Student student = studentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found with given id:" + id));
    studentRepository.delete(student);
    return "Student deleted successfully";
  }

  @Override
  public StudentDTO getStudentByEmail(String email) {
    Student student = studentRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found with given email:" + email));
    return StudentMapper.StudentToStudentDTO(student);
  }
}
