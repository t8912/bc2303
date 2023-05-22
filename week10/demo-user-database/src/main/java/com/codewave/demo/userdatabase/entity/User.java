package com.codewave.demo.userdatabase.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Table(name = "TUSERS")
//@Builder
public class User implements Serializable  {
  
  public User() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME")
  String fullName;

  @Column(name = "USER_NAME")
  String userName;

  @Column(name = "USER_EMAIL")
  String userEmail;

  @Column(name = "USER_PHONE")
  String userPhone;

  @Column(name = "USER_WEBSITE")
  String userWebsite;

}
