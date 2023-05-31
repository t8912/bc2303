package com.codewave.demo.demomockmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.demomockmvc.model.Country;

@Service
public class CountryService {

  @Autowired

  public Country getCountry() {
   return Country.builder()
   .name("UK")
   .latitude(110.93)
   .longitude(120.4)
   .build();
  }

  public Country createCountry() {
    return Country.builder()
    .name("BCD")
    .latitude(110.93)
    .longitude(120.4)
    .build();
   }

   public Country deleteBook() {

   }

   public List<Country> getGountries() {
    return Arrays.asList(new Country("US", 120.02, 190.9)),
    new Country("UK", 110.02, 90.3));
   }
  
}
