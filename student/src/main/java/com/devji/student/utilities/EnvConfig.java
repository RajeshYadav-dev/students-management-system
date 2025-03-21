package com.devji.student.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
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
