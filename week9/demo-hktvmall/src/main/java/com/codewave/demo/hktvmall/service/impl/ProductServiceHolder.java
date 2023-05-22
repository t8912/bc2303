package com.codewave.demo.hktvmall.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.hktvmall.entity.Product;
import com.codewave.demo.hktvmall.repository.ProductRepository;
import com.codewave.demo.hktvmall.service.ProductService;

@Service //Bean -> new 
public class ProductServiceHolder implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public List<Product> findByStatus(Character status) {
    return productRepository.findByStatus(status);
  }

  @Override
  public List<Product> findByQuantityGreaterThan(Integer quantity) {
    return productRepository.findByQuantityGreaterThan(quantity);
  }

  @Override
  public List<Product> findByStatusAndCreatedDateGreaterThan(Character status, LocalDate createdDate) {
    return productRepository.findByStatusAndCreatedDateGreaterThan(status, createdDate);
  }

  @Override
  public List<Product> findAllByNativeQuery() {
    return productRepository.findAll();
  }

}
