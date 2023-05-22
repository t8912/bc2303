package com.codewave.demo.hktvmall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TPRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

  @Id
  //@Column(name = "PRODUCT_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_generator")
  private Long id; // TBC.

  @Column(name = "CREATED_DATE")
  private LocalDate createdDate;

  @Column(name = "PRODUCT_NAME")
  private String productName;

  @Column(name = "UNIT_PRICE")
  private BigDecimal unitPrice;

  private Integer quantity;

  private Character status; // TBC.

  //@OneToMany(mappedBy = "product")
  //@JsonIgnoreProperties({ "product" })
  //private List<ProductDiscount> productDiscounts = new ArrayList<>();

}
