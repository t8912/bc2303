package com.codewave.demo.hktvmall.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.hktvmall.entity.Product;
import com.codewave.demo.hktvmall.entity.ProductDiscount;
import com.codewave.demo.hktvmall.repository.ProductDiscountRepository;
import com.codewave.demo.hktvmall.repository.ProductRepository;
import com.codewave.demo.hktvmall.service.ProductDiscountService;

@Service
public class ProductDiscountServiceHolder implements ProductDiscountService {

  @Autowired
  ProductDiscountRepository productDiscountRepository;

  @Autowired
  ProductRepository productRepository;

  @Override
  public List<ProductDiscount> findAllByProductId(Long id) {
    List<ProductDiscount> list = productDiscountRepository.findAllByProductId(id);
    System.out.println(list);
    return list;
  }

  @Override
  public ProductDiscount save(ProductDiscount productDiscount, Long id) {
    System.out.println("start to save discount");
    Product product = productRepository.findById(id).orElse(null);
    System.out.println("Got product=" + product);

    productDiscount.setProduct(product);

    ProductDiscount discount = productDiscountRepository.save(productDiscount);
    System.out.println("discount=" + discount);

    return productDiscountRepository.save(productDiscount); // because productDiscount has no product id
  }

}
