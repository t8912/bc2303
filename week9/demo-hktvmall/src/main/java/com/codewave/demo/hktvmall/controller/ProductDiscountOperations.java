package com.codewave.demo.hktvmall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.entity.ProductDiscount;
//import com.codewave.demo.hktvmall.infra.response.ApiResponse;
//import com.codewave.demo.hktvmall.model.dto.response.ProductDiscountDTO;
import com.codewave.demo.hktvmall.model.dto.response.ProductDiscountDTO;

public interface ProductDiscountOperations {

  @PostMapping(value = "/product/{id}/productdiscount")
  ResponseEntity<ApiResponse<ProductDiscountDTO>> save(@RequestBody ProductDiscount productDiscount,
      @PathVariable(name = "id") Long id);

  @GetMapping(value = "/product/{id}/productdiscounts")
  ResponseEntity<ApiResponse<List<ProductDiscountDTO>>> findAll(@PathVariable(name = "id") Long id);

}
