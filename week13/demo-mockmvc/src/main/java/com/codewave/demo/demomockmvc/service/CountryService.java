package com.codewave.demo.demomockmvc.service;

import org.springframework.stereotype.Service;

import com.codewave.demo.demomockmvc.model.Country;

@Service
public class CountryService {

  public Country getCountry() {
   return Country.builder()
   .name("UK")
   .latitude(110.93)
   .longitude(120.4)
   .build();
  }
  
}
