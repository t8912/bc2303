package com.codewave.demo.hktvmall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

//import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TPRODUCT_DISCOUNTS")
public class ProductDiscount implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "DISCOUNT_ID")
  private Long id;

  //@Column(name = "PRODUCT_ID")
  //private Long productId;

  @Column(name = "START_DATE")
  private LocalDate startDate;

  @Column(name = "END_DATE")
  private LocalDate endDate;

  @Column(name = "UNIT_DISCOUNT_RATIO")
  private BigDecimal discountRatio;

  @Column(name = "UNIT_DISCOUNT_PRICE")
  private BigDecimal discountPrice;

  private Character status;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false) // foreign key is not nullable
  // @OnDelete(action = OnDeleteAction.CASCADE)
  // @JsonIgnore
  private Product product;
  
}
