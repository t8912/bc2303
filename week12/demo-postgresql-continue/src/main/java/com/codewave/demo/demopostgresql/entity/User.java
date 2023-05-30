package com.codewave.demo.demopostgresql.entity;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TUSERS")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME")
  String fullName;

  @Column(name = "USER_NAME")
  String userName;

  @Column(name = "USER_EMAIL")
  String email;

  @Column(name = "USER_PHONE")
  String phone;

  @Column(name = "USER_WEBSITE")
  String website;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  // @EqualsAndHashCode.Exclude // <<<<<<<<<<
  // @ToString.Exclude // <<<<<<<
  final List<Post> posts = new ArrayList<>();

  public boolean addPost(Post post) {
   return posts.add(post);
  }

}