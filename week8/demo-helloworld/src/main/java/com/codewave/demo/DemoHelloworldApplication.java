package com.codewave.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codewave.demo.controller.impl.HelloworldController;

@SpringBootApplication
public class DemoHelloworldApplication {

	public static void main(String[] args) {
		// Start Application
		SpringApplication.run(DemoHelloworldApplication.class, args);
	 String a = "hello";
	 a = "hello4";
	 System.out.println(a);
	 // After a pointing to "hello2", " hello" will be removed after certain period

	 HelloworldController controller = new HelloworldController();
	 System.out.println(controller.sayHello());

	}

}
