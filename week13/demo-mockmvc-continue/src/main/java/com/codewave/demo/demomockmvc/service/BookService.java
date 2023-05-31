package com.codewave.demo.demomockmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.demomockmvc.entity.Book;
import com.codewave.demo.demomockmvc.repository.BookRepository;
@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  public Book deleteById(Long id) {
  Book book = bookRepository.findById(id).orElse(null);
  if (book == null)
  return null;
  bookRepository.deleteById(id);
  return book;
  }
  
}
