package com.codewave.demo.hktvmall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.demo.hktvmall.entity.ProductDiscount;

//@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {
  // select * from TPRODUCT_DISCOUNTS where id = ?;
  List<ProductDiscount> findAllByProductId(Long id);

}