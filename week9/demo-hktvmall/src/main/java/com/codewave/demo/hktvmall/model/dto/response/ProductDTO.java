package com.codewave.demo.hktvmall.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO { // Product Data Transfer Object

  private Long id; // TBC.

  private LocalDate createdDate;

  private String productName;

  private BigDecimal unitPrice;

  private Integer quantity;

  private String status; // TBC.


}

