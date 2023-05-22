package com.codewave.demo.hktvmall.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codewave.demo.hktvmall.entity.Product;

@Repository
// Object Relation Mapping (ORM), JPA, Hibernate
public interface ProductRepository extends JpaRepository<Product, Long> {
  // jpa.save() -> PostMapping

  // select * from TPRODUCTS where status = ?;
  List<Product> findByStatus(Character status);

  // @Query(value = "select * from TPRODUCTS where quantity > ?;")
  // findByQuantityGreaterThanEqual(Integer quantity);
  List<Product> findByQuantityGreaterThan(Integer quantity);

  // select * from TPRODUCTS where status = ? and created_date > ?;
  List<Product> findByStatusAndCreatedDateGreaterThan(Character status, LocalDate createdDate);

  @Query(value = "SELECT * FROM TPRODUCTS", nativeQuery = true)
  List<Product> findAll();

}
 
