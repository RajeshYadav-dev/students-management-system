package com.devji.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devji.student.datatransferobject.StudentDTO;
import com.devji.student.services.StudentServices;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  private final StudentServices studentServices;

  @PostMapping("")
  public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
    StudentDTO saveStudent = studentServices.addStudent(studentDTO);
    return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
  }

  @GetMapping("")
  public ResponseEntity<List<StudentDTO>> getAllStudent() {
    List<StudentDTO> students = studentServices.getAllStudent();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
    StudentDTO student = studentServices.getStudentById(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
    StudentDTO updatedStudent = studentServices.updateStudent(id, studentDTO);
    return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
    String message = studentServices.deleteStudent(id);
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable String email) {
    StudentDTO student = studentServices.getStudentByEmail(email);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

}
