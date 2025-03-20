package com.devji.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devji.student.utilities.EnvConfig;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

		new EnvConfig().getEnv();

		SpringApplication.run(StudentApplication.class, args);
	}

}
