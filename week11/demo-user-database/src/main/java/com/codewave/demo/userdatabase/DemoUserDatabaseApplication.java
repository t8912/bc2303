package com.codewave.demo.userdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = CommentController.class)
public class DemoUserDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserDatabaseApplication.class, args);
	}

}
