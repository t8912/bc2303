package com.codewave.demo.controller;

//import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.codewave.demo.model.ExternalResponse;
//import com.codewave.demo.model.Person;

public interface HelloworldOperations {
  @GetMapping(value = "/greeting")
  String sayHello();

  @GetMapping(value = "/persons")

  //List<Person> getPersons();
  ExternalResponse getPersons();
  
}
