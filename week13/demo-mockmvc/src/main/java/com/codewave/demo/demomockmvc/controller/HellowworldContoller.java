package com.codewave.demo.demomockmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.demomockmvc.model.Country;
import com.codewave.demo.demomockmvc.service.CountryService;

@RestController
@RequestMapping("/api/v1")
public class HellowworldContoller {

  @Autowired
  CountryService countryService;

  @GetMapping (value = "/hello")
  public String helloWorld() {
      return "Hello World!";
  }

  @GetMapping (value = "/country")
  public Country getGountry() {
    return Country.builder()
    .name("US")
    .latitude(14.456)
    .longitude(100.789)
    .build();
  }
  
  @GetMapping (value = "/country2")
  public Country getGountry2() {
    return Country.builder()
    .name("US")
    .latitude(14.456)
    .longitude(100.789)
    .build();
  }
  
  @GetMapping (value = "/country2/{id}/{name}")
  public Country geCountry2(@PathVariable(value = "id")Long id,
  @PathVariable(value = "name") String name,
  @RequestParam(value = "age") Integer age) {
    if (id == 1) {
      return new Country();
    } else if (id ==2 || "ABC".equals(name) || age == 30 ) {
      return new Country("ABC", 12.2, 13.3);
    }
    
    return countryService.getCountry(); // return mockbean "CN"
  }
}
