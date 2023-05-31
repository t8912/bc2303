package com.codewave.demo.demomockmvc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.codewave.demo.demomockmvc.entity.Book;
import com.codewave.demo.demomockmvc.repository.BookRepository;

import jakarta.inject.Inject;

@SpringBootTest // full load all bens in context
//@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    //Approach 1: @SpringBootTest + @MockBean (To test springcontext as well)
    //Approach 2: No @SpringVootTest, Mock Only (Normal method test)



  // @Autowired
  // private BookService bookService;

  //Autowired -> H2 Database
  @MockBean
  //@Mock
  BookRepository bookRepository;

  @InjectMocks // inject MockBean bookRepository into bookservice
  BookService bookService;


  @Test
  void givenMockedBookRepository_whenDeleteById_thenReturnBook() {
   Book book = new Book(2L, "abc", BigDecimal.valueOf(30.4));

    Mockito.when(bookRepository.findById(2L))
    .thenReturn(Optional.of(book));

    Assertions.assertEquals(bookservice.deleteById(2L), book);
  }
}