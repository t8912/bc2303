package com.codewave.demo.demoopenapidoc.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarPark {

 private Integer capacity;

 private List<Car> cars;

 public void  init() {
  cars = new ArrayList<>();
 }
  
}
