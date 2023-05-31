package com.codewave.demo.demomockmvc.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hamcrest.beans.HasProperty;
import org.hibernate.annotations.TimeZoneStorage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import com.codewave.demo.demomockmvc.entity.Book;
import com.codewave.demo.demomockmvc.repository.BookRepository;

@DataJpaTest // Similar to you use @WebMvcTest in ControllerTest
class BookRepositoryTest {

  // @MockBean
  // BookRepository bookRepository;

  @Autowired
  BookRepository realBookRepository;

// @Test
// void giveMockedRepositoryMethods_whenCallReposMethod_thenCorrect() {
//   Optional<Book> book = Optional.of(new Book(1L, "John", BigDecimal.valueOf(30.4)));
//   Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(new Book()));

//   Assertions.assertEquals(book, bookRepository.findById(1L));

//   assertThat(bookRepository.findById(1L).orElse(null),
//   HasProperty("author", is("John")));
 
// }
  
@Test
void givenRealBookRepository_whenCallReporosMethod_thenCorrect() {
  Book book = new Book(null, "Alex", BigDecimal.valueOf(40.9));

  Book savedBook = realBookRepository.save(book);

  assertThat(savedBook, hasProperty("author", is("Alex")));
  assertThat(savedBook, HasProperty("id", is(1L)));

}

@Test
@Sql(scripts = { "classpath:dml/DML_CREATE_BOOK.sql"})
void givenRealBookRepository_whenFindById_thenCorrect() {
  Book book = realBookRepository.findById(1L).orElse(null);
  assertThat(book, hasProperty("author", is("Eric")));

  assertThat(book).
  

}
  
}
