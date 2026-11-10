package com.example.StudentRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.StudentRegistration",
		"config",
		"controller",
		"model",
		"repository",
		"service"
})
public class StudentRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				StudentRegistrationApplication.class,
				args
		);
	}
}