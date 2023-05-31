package com.codewave.demo.swagger.controller;

import java.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1")
public interface HelloworldOperation {
  
  @GetMapping(value = "/currency")
  Currency getCurrenct();
  
}
