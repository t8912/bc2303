package com.codewave.demo.hktvmall.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.codewave.demo.hktvmall.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDiscountDTO { // Product Data Transfer Object

  private Long id;

  private LocalDate startDate;

  private LocalDate endDate;

  private BigDecimal discountRatio;

  private BigDecimal discountPrice;

  private Character status;

  //private ProductDTO productDTO;

}
