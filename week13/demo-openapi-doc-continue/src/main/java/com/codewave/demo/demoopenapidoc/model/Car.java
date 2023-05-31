package com.codewave.demo.demoopenapidoc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Car {

  //NotNull(message = "Custom message for Not null") // business requirement
  private Color color;

  //@NotBlank(message = "Custom message for not blank") // business requirement
  //@Size(min = 3, max = 6) // business requirment
  private String model;


  
}
