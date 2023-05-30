package com.codewave.demo.demopostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.codewave.demo.demopostgresql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}

/* 
// JPQL
// Native Query -> @Query
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUserName(String userName);

  boolean existsByUserName(String userName);

  @Modifying // Update/ Delete
  @Query(value = "DELETE FROM Post c WHERE c.id = :id") // JPQL
  int deleteByIdReturnCount(@Param("id") Long id);

}

*/
