package com.codewave.demo.hktvmall.controller.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.controller.ProductOperations;
import com.codewave.demo.hktvmall.entity.Product;
//import com.codewave.demo.hktvmall.infra.response.ApiResponse;
import com.codewave.demo.hktvmall.model.dto.response.ProductDTO;
import com.codewave.demo.hktvmall.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/admin/api/v1")
@Slf4j
public class ProductController implements ProductOperations {

  @Autowired
  ProductService productService;

  @Autowired
  ModelMapper mapper;

  @Override
  public ResponseEntity<ApiResponse<ProductDTO>> save(Product product) {
    //log.info("getProductDiscounts={}", product.getProductDiscounts());

    Product result = productService.save(product);

    // Given that the number of fields in ProductDto < Product
    // ModelMapper mapper = new ModelMapper();
    ProductDTO responseDto = mapper.map(result, ProductDTO.class);

    ApiResponse<ProductDTO> response = ApiResponse.<ProductDTO>builder()
        .ok()
        .data(responseDto)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<ProductDTO>> findById(Long id) {
    Product result = productService.findById(id).orElse(null);
    // ModelMapper mapper = new ModelMapper();
    ProductDTO responseDto = mapper.map(result, ProductDTO.class);

    ApiResponse<ProductDTO> response = ApiResponse.<ProductDTO>builder()
        .ok()
        .data(responseDto)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDTO>>> findAll() {
    List<Product> products = productService.findAll();
    // ModelMapper mapper = new ModelMapper();

    List<ProductDTO> productDTOs = products.stream()
        .map(e -> mapper.map(e, ProductDTO.class))
        .collect(Collectors.toList());

    ApiResponse<List<ProductDTO>> response = ApiResponse.<List<ProductDTO>>builder()
        .ok()
        .data(productDTOs)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDTO>>> findByStatus(Character status) {
    List<Product> products = productService.findByStatus(status);
    // ModelMapper mapper = new ModelMapper();

    List<ProductDTO> productDTOs = products.stream()
        .map(e -> mapper.map(e, ProductDTO.class))
        .collect(Collectors.toList());

    ApiResponse<List<ProductDTO>> response = ApiResponse.<List<ProductDTO>>builder()
        .ok()
        .data(productDTOs)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDTO>>> findByQuantityGreaterThan(Integer quantity) {
    List<Product> products = productService.findByQuantityGreaterThan(quantity);

    List<ProductDTO> productDTOs = products.stream()
        .map(e -> mapper.map(e, ProductDTO.class))
        .collect(Collectors.toList());

    ApiResponse<List<ProductDTO>> response = ApiResponse.<List<ProductDTO>>builder()
        .ok()
        .data(productDTOs)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDTO>>> findByStatusAndCreatedDateGreaterThan(Character status,
      LocalDate createdDate) {
    List<Product> products = productService.findByStatusAndCreatedDateGreaterThan(status, createdDate);

    List<ProductDTO> productDTOs = products.stream()
        .map(e -> mapper.map(e, ProductDTO.class))
        .collect(Collectors.toList());

    ApiResponse<List<ProductDTO>> response = ApiResponse.<List<ProductDTO>>builder()
        .ok()
        .data(productDTOs)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<ProductDTO>>> findAllByNativeQuery() {
    List<Product> products = productService.findAll();

    List<ProductDTO> productDTOs = products.stream()
        .map(e -> mapper.map(e, ProductDTO.class))
        .sorted((e1, e2) -> e1.getId() > e2.getId() ? -1 : 1) // desending order
        .collect(Collectors.toList());

    ApiResponse<List<ProductDTO>> response = ApiResponse.<List<ProductDTO>>builder()
        .ok()
        .data(productDTOs)
        .build();
    return ResponseEntity.ok().body(response);
  }

}