package com.codewave.demo.userdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewave.demo.userdatabase.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  
}
