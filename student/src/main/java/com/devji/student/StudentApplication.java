package com.devji.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

		new EnvConfig().getEnv();

		SpringApplication.run(StudentApplication.class, args);
	}

}

class EnvConfig {
	public Dotenv getEnv() {
		Dotenv dotenv = Dotenv.configure()
				.directory("F:\\java\\.env")
				.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		return dotenv;
	}
}