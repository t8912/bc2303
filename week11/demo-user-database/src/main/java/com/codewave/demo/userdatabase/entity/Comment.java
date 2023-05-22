package com.codewave.demo.userdatabase.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TCOMMENTS")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // @Column(name = "POST_ID")
  // String postId;

  @Column(name = "COMMENT_NAME")
  private String name;

  @Column(name = "COMMENT_BODY")
  private String body;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "POST_ID", nullable = false)
  // @EqualsAndHashCode.Exclude // <<<<<<<<<<
  // @ToString.Exclude // <<<<<<<
  private Post post;

}
