package com.codewave.demo.userdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewave.demo.userdatabase.entity.User;

// JPQL
// Native Query -> @Query
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUserName(String userName);

  boolean existsByUserName(String userName);

  @Modifying // Update/ Delete
  @Query(value = "DELETE FROM Post c WHERE c.id = :id") // JPQL
  int deleteByIdReturnCount(@Param("id") Long id);

}
