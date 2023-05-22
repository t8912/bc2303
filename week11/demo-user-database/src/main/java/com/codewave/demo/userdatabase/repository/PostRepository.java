package com.codewave.demo.userdatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewave.demo.userdatabase.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findAllByUserId(Long UserId);

  @Modifying // Update/ Delete
  @Query(value = "DELETE FROM Post c WHERE c.id = :id") // JPQL
  int deleteByIdReturnCount(@Param("id") Long id);

}
