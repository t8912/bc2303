package com.codewave.demo.demomockmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codewave.demo.demomockmvc.entity.Book;

public interface CountryRepository extends JpaRepository<Book, Long> {

  // @Query("")
  // Book deleteByIdReturnBook(Long id);
  
}
