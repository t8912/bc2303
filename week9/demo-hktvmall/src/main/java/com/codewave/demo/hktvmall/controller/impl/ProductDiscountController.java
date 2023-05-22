package com.codewave.demo.hktvmall.controller.impl;

import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.controller.ProductDiscountOperations;
import com.codewave.demo.hktvmall.entity.ProductDiscount;
//import com.codewave.demo.hktvmall.infra.response.ApiResponse;
import com.codewave.demo.hktvmall.model.dto.response.ProductDiscountDTO;
import com.codewave.demo.hktvmall.service.ProductDiscountService;

@RestController
@RequestMapping(value = "/admin/api/v1")
public class ProductDiscountController implements ProductDiscountOperations {

  @Autowired
  ProductDiscountService productDiscountService;

  @Autowired
  ModelMapper mapper;

  @Override
  public ResponseEntity<ApiResponse<ProductDiscountDTO>> save(ProductDiscount productDiscount, Long id) {
    ProductDiscount discount = productDiscountService.save(productDiscount, id);

    ProductDiscountDTO responseDto = mapper.map(discount, ProductDiscountDTO.class);

    ApiResponse<ProductDiscountDTO> response = ApiResponse.<ProductDiscountDTO>builder()
        .ok()
        .data(responseDto)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDiscountDTO>>> findAll(Long id) {
    List<ProductDiscount> discounts = productDiscountService.findAllByProductId(id);

    List<ProductDiscountDTO> responseDto = discounts.stream()
        .map(discount -> mapper.map(discount, ProductDiscountDTO.class))
        .collect(Collectors.toList());

    ApiResponse<List<ProductDiscountDTO>> response = ApiResponse.<List<ProductDiscountDTO>>builder()
        .ok()
        .data(responseDto)
        .build();
    return ResponseEntity.ok().body(response);
  }
}

