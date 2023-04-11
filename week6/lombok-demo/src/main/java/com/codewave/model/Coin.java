package com.codewave.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coin {

  private BigDecimal marketCap;
 
  private String description;

}
