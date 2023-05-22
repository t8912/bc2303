package com.codewave.demo.hktvmall.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.entity.Product;
import com.codewave.demo.hktvmall.model.dto.response.ProductDTO;

public interface ProductOperations {

  @PostMapping(value = "/product")
  ResponseEntity<ApiResponse<ProductDTO>> save(@RequestBody Product product);

  @GetMapping(value = "/product/{id}")
  ResponseEntity<ApiResponse<ProductDTO>> findById(@PathVariable(value = "id") Long id);

  @GetMapping(value = "/products")
  ResponseEntity<ApiResponse<List<ProductDTO>>> findAll();

  @GetMapping(value = "/product/status/{status}")
  ResponseEntity<ApiResponse<List<ProductDTO>>> findByStatus(@PathVariable Character status);

  @GetMapping(value = "/product/quantity/greaterthan/{quantity}")
  ResponseEntity<ApiResponse<List<ProductDTO>>> findByQuantityGreaterThan(@PathVariable Integer quantity);

  @GetMapping(value = "/product/status/{status}/createddate/{createdDate}")
  ResponseEntity<ApiResponse<List<ProductDTO>>> findByStatusAndCreatedDateGreaterThan(@PathVariable Character status,
      @PathVariable LocalDate createdDate);

  @GetMapping(value = "/nativequery/products")
  ResponseEntity<ApiResponse<List<ProductDTO>>> findAllByNativeQuery();

}
