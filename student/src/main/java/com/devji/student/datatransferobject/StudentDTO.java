package com.devji.student.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private String city;
  private String email;
  private String gender;
  private String dob;
  private String createdAt;
  private String updatedAt;
}
