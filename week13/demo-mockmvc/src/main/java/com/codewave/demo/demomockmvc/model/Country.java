package com.codewave.demo.demomockmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

  private String name;
  
  private double latitude;
  private double longitude;
  
}
