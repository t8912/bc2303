package com.codewave.demo.userdatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewave.demo.userdatabase.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findAllByPostId(Long postId);

  @Modifying // Update/ Delete
  @Query(value = "DELETE FROM Comment c WHERE c.id = :id") // JPQL
  int deleteByIdReturnCount(@Param("id") Long id);

}
