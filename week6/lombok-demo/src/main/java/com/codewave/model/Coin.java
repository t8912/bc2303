package com.codewave.model;

import java.math.BigDecimal;

import javax.swing.plaf.TreeUI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Builder
//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Coin extends Crypto {

  private BigDecimal marketCap;
 
  private String description;

  public Coin(BigDecimal maketCap, String description, String address) {
    super(address);
    this.marketCap = maketCap;
    this.description = description;
  }

}
