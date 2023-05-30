package com.codewave.demo.demomockmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.codewave.demo.demomockmvc.model.Country;
import com.codewave.demo.demomockmvc.service.CountryService;

@SpringBootTest // Class Level Annotation
@AutoConfiguration // Inject mockmvc related bean into context
public class HellowworldControllerTest {

@Autowired
MockMvc mockMvc; // A tool to perform api call, just like Postman

@MockBean
CountryService countryService;

  @Test
  void testHello() {
    mockMvc.perform(get("/api/v1/hello"))
    .andExpect(status().isOK())
    .andExpect(content().string("hello world!"));
    .andDo(print());
  }

  // @Test
  // void testHello() {
  //   mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hello"))
  //   .andExpect(MockMvcResultMatchers.status().isOK())
  //   .andExpect(MockMvcResultMatchers.content().string("hello world!"));
  //   .andDo(print());

  // }

  @Test
  void getGountry() {
    mockMvc.perform(get("/api/v1/country").accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOK())
    //.andExpect(content().string("hello world!"));
    .andExpect(jsonPath("$.name").value("US"))
    .andExpect(jsonPath("$.latitude").value(14.456))
    .andExpect(jsonPath("$.longitude").value(100.789))
    .andDo(print());
  }
  
@Test
void giveMockCountryService_whenUnitTestConrollerGetCountry2_thenMockMvcCorrect() throws Exception{
  Mockito.when(countryService.getCountry()).thenReturn(new Country("CN", 10.3, 14.5));

  mockMvc
  .perform(get("/api/v1/country2/{id}/{value}", 4, "ABC")
        .param("age", "30")
        .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.name").value("ABC"))
    .andExpect(jsonPath("$.latitude").value(12.2))
    .andExpect(jsonPath("$.longitude").value(13.3))
    .andDo(print());

  mockMvc
    .perform(get("/api/v1/country2/{id}/{value}", 4, "XYZ")
        .param("age", "35")
        .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
     .andExpect(jsonPath("$.name").value("CN"))
    .andExpect(jsonPath("$.latitude").value(10.3))
     .andExpect(jsonPath("$.longitude").value(14.5))
    .andDo(print());
  }

  mockMvc
   .perform(get("/api/v1/country2/{id}/{value}", 4, "XYZ")
       // .param("age", "35")
        .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isBadRequest())
    .andDo(print());
  }


}
