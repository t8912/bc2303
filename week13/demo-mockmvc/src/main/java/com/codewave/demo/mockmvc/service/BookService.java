package com.codewave.demo.mockmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.mockmvc.entity.Book;
import com.codewave.demo.mockmvc.repository.BookRepository;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  /**
   * if delete success, return Book, otherwise, return null
   * 
   * @param id
   * @return
   */
  public Book deleteById(Long id) {
    Book book = bookRepository.findById(id).orElse(null);
    if (book == null)
      return null;
    bookRepository.deleteById(id);
    return book;
  }
}
