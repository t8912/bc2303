package com.codewave.demo.userdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewave.demo.userdatabase.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  // JPQL
  // Native Query -> @Query
}
