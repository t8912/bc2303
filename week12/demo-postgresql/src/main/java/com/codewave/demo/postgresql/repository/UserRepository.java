package com.codewave.demo.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewave.demo.postgresql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
