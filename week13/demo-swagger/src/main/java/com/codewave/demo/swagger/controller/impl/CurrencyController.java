package com.codewave.demo.swagger.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.swagger.controller.CurrencyOperations;
import com.codewave.demo.swagger.model.Currency;

@RestController
@RequestMapping(value = "/currencies/api/v1")
public class CurrencyController implements CurrencyOperations {

  @Override
  public Currency getCurrency() {
    return new Currency("USD", "US Dollar");
  }

}
