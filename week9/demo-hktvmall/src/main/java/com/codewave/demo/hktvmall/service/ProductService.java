package com.codewave.demo.hktvmall.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.codewave.demo.hktvmall.entity.Product;


public interface ProductService {
  
  Product save(Product product);

  Optional<Product> findById(Long id);

  List<Product> findAll();

  List<Product> findByStatus(Character status);

  List<Product> findByQuantityGreaterThan(Integer quantity);

  List<Product> findByStatusAndCreatedDateGreaterThan(Character status, LocalDate createdDate);

  List<Product> findAllByNativeQuery();

}
