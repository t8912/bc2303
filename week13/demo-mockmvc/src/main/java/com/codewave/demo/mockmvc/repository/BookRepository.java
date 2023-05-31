package com.codewave.demo.mockmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.demo.mockmvc.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
