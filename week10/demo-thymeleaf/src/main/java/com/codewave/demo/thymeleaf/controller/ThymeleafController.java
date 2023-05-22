package com.codewave.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/demo/thymeleaf/v1")
public class ThymeleafController {

  @GetMapping(value = "/greeting") 
  public String greeting1(@RequestParam(name = "name", defaultValue = "World") String name, Model model) {
   
    //call service
    model.addAttribute("name", name);
    model.addAttribute("age", name);
    
    return "index";
  }
  
}
