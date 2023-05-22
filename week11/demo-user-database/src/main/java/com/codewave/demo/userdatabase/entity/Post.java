package com.codewave.demo.userdatabase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TPOSTS")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Post implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  // @Column(name = "USER_ID")
  // String userId;

  @Column(name = "POST_TITLE")
  String title;

  @Column(name = "POST_BODY")
  String body;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  // @EqualsAndHashCode.Exclude // <<<<<<<<<<
  // @ToString.Exclude // <<<<<<<
  final List<Comment> comments = new ArrayList<>();

  public boolean addComment(Comment comment) {
    return comments.add(comment);
  }

}
