package com.codewave.demo.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.codewave.demo.swagger.model.Currency;

import io.swagger.annotations.ApiOperation;

public interface CurrencyOperations {
  
  @ApiOperation(value = "Get")
  @GetMapping(value = "/currency")
  Currency getCurrency();
  
}
