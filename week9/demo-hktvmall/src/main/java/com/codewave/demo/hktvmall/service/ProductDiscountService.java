package com.codewave.demo.hktvmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.event.TransactionalEventListener;

import com.codewave.demo.hktvmall.entity.ProductDiscount;


public interface ProductDiscountService {

  List<ProductDiscount> findAllByProductId(Long id);

  @Transactional
  ProductDiscount save(ProductDiscount productDiscount, Long id);

}

