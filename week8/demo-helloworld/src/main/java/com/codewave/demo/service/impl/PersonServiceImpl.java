package com.codewave.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewave.demo.model.Person;
import com.codewave.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

  @Override
  public List<Person> getPersons(){
    Person p1 = Person.builder() //
        .name("John")
        .email("john@gmail.com")
        .age(30)
        .build();

    Person p2 = Person.builder() //
        .name("Mary")
        .email("mary@gmail.com")
        .age(35)
        .build();
  Person p3 = new Person("Alex", "alex@hotmail.com", 40);
    return Arrays.asList(p1, p2, p3);

  } 
  
}
