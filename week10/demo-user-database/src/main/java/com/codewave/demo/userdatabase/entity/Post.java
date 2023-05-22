package com.codewave.demo.userdatabase.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "TPOSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TITLE")
    String title;

    @Column(name = "BODY")
    String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    User user;
}


/* 
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TPOSTS")
public class Post implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  // @Column(name = "USER_ID")
  // String userId;

  @Column(name = "POST_TITLE")
  String postTitle;

  @Column(name = "POST_BODY")
  String postBody;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

}

*/
