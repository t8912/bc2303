package com.codewave.demo.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v2")
public class Helloworld2Controller {

@GetMapping(value = "/helloworld2")
public String helloworld2(){
  return "Hello World!2";
}

  
}
