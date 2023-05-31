package com.codewave.demo.mockmvc.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.codewave.demo.mockmvc.entity.Book;

@DataJpaTest // Similar to you use @WebMvcTest in ControllerTest
class BookRepositoryTest {

  @Autowired
  BookRepository realBookRepository;

  @Test
  void testNotNull() {
    assertThat(realBookRepository, is(notNullValue()));
  }

  @Test
  void givenRealBookRepository_whenCallReposMethod_thenCorrect() {
    Book book = new Book(null, "Alex", BigDecimal.valueOf(40.9));

    Book savedBook = realBookRepository.save(book);

    assertThat(savedBook, hasProperty("author", is("Alex")));
    assertThat(savedBook, hasProperty("id", is(1L)));
  }

  @Test
  @Sql(scripts = { "classpath:dml/DML_CREATE_BOOK.sql" })
  void givenRealBookRepository_whenFindById_thenCorrect() {
    Book book = realBookRepository.findById(1L).orElse(null);
    assertThat(book, hasProperty("author", is("Eric")));
    assertThat(book, notNullValue());
  }

}
