package com.codewave.demo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codewave.demo.controller.HelloworldOperations;
import com.codewave.demo.model.ExternalResponse;
import com.codewave.demo.model.Person;
import com.codewave.demo.model.School;
import com.codewave.demo.service.impl.PersonServiceImpl;
import com.codewave.demo.service.impl.SchoolServiceimpl;

@Controller
@ResponseBody // default JSON
@RequestMapping(value = "/api/v1")
public class HelloworldController implements HelloworldOperations {

  @Autowired // get PersonServiceimpl(); // from SpringContext
  PersonServiceImpl p; // inject personServiceImpl object into p, p is a reference


  @Autowired
  SchoolServiceimpl s;
 
  @Override
  public String sayHello() {
    return "Hello World!";
    // {
    // "name" : "John"
    // }
  }

  /**
   * JAVA Doc // e.g Get all person data from database table Persons
   */
  @Override
  public ExternalResponse getPersons() {
      School s2 = s.getSchools().stream()
      .filter(e -> e.getName().startsWith("ABC")) // after filter, List<School>
      .findFirst() //
      .orElse(new School());

    return ExternalResponse.builder()
    .school(s2)
    .persons(p.getPersons())
    .build();

  }
}
    //return response;
//School s = School.builder() //
  //public List<Person> getPersons() {
    // PersonServiceImpl p = new PersonServiceImpl();
    //eturn p.getPersons();

    // Person[] will be the same example
    /// Person p1 = Person.builder() //
    /// .name("John")
    /// .email("john@gmail.com")
    /// .age(30)
    /// .build();

    /// Person p2 = Person.builder() //
    /// .name("Mary")
    /// .email("mary@gmail.com")
    /// .age(35)
    /// .build();

    /// return Arrays.asList(p1, p2);
  //}
//}
