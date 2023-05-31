package com.codewave.demo.mockmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.mockmvc.model.Country;
import com.codewave.demo.mockmvc.service.CountryService;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  @Autowired
  CountryService countryService;

  @GetMapping(value = "/hello")
  public String hello() {
    return "hello world!";
  }

  @GetMapping(value = "/country")
  public Country getCountry() {
    return Country.builder()
        .name("US")
        .latitude(14.456)
        .longitude(100.789)
        .build();
  }

  @GetMapping(value = "/country2/{id}/{name}")
  public Country getCountry2(@PathVariable(value = "id") Long id,
      @PathVariable(value = "name") String name,
      @RequestParam(value = "age") Integer age) {
    if (id == 1) {
      return new Country();
    } else if (id == 2 || "ABC".equals(name) || age == 30) {
      return new Country("ABC", 12.2, 13.3);
    }
    return countryService.getCountry(); // retrun mockbean "CN"
  }

  @PostMapping(value = "/country")
  @ResponseStatus(value = HttpStatus.CREATED)
  public Country createCountry(@RequestBody Country country) {
    return countryService.createCountry();
  }

  @GetMapping(value = "/countries")
  public List<Country> getCountries() {
    return countryService.getCountries();
  }

}
