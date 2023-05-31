package com.codewave.demo.demomockmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBOOKS")
public class Book implements Serializable {

  @Id
  @GeneratedValue
  Long id;
  
  String author;

  BigDecimal price;
  
}
