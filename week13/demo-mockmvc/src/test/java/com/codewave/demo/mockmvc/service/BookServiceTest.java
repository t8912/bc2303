package com.codewave.demo.mockmvc.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codewave.demo.mockmvc.entity.Book;
import com.codewave.demo.mockmvc.repository.BookRepository;

@SpringBootTest // full load all beans in context
// @AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  // Apporach 1: @SpringBooTest + @MockBean (To test springcontext as well)
  // Approach 2: No @SpringBootTest, @Mock Only (Normal method test)

  // Autowird -> H2 database
  // @MockBean
  @MockBean
  BookRepository bookRepository;

  @InjectMocks // inject MockBean bookRepository into bookservice
  BookService bookService;

  @Test
  void givenMockedBookRepository_whenDeleteById_thenReturnBook() {
    Book book = new Book(2L, "abc", BigDecimal.valueOf(30.4));

    Mockito.when(bookRepository.findById(2L))
        .thenReturn(Optional.of(book));

    Assertions.assertEquals(bookService.deleteById(2L), book);
  }

}
