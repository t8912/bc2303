package com.codewave.demo.demomockmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
// import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.RequestBuilder;

import com.codewave.demo.demomockmvc.model.Country;
import com.codewave.demo.demomockmvc.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@WebMvcTest // RestController, controlleradvise, But not @service, @Repository, etc.
//@SpringBootTest // Full Load, Class Level Annotation
//@AutoConfigureMockMvc // Inject mockmvc related bean into context
@TestInstance(Lifecycle.PER_CLASS) //due to objectMApper init()
public class HellowworldControllerTest {

@Autowired
MockMvc mockMvc; // A tool to perform api call, just like Postman

@MockBean // To test "@Autowired" in main code (Controller autowired service)
CountryService countryService;

private ObjectMapper objectMapper;

@BeforeAll
void init() {
  objectMapper = new ObjectMapper();
}

  @Test
  void testHello() throws Exception {
    mockMvc.perform(get("/api/v1/hello"))
    .andExpect(status().isOk())
    .andExpect(content().string("hello world!"))
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
  void getCountry() throws Exception {
    mockMvc.perform(get("/api/v1/country").accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    //.andExpect(content().string("hello world!"));
    .andExpect(jsonPath("$.name").value("US"))
    .andExpect(jsonPath("$.latitude").value(14.456))
    .andExpect(jsonPath("$.longitude").value(100.789))
    .andDo(print());
  }
  
@Test
void giveMockCountryService_whenUnitTestConrollerGetCountry2_thenMockMvcCorrect() throws Exception {
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
  

  mockMvc
   .perform(get("/api/v1/country2/{id}/{value}", 4, "XYZ")
       // .param("age", "35")
        .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isBadRequest())
    .andDo(print());
 
  }

  @Test
  void giveMockCountryService_whenUnitTestConrollerCreateCountry_thenMockMvcCorrect() throws Exception {
  
  JSONObject request = new JSONObject()
  .put("name", "TUI")
  .put("latitude", 123.0)
  .put("longitude", 9.0);


  Country mockCountry = objectMapper.readValue(request.toString(), Country.class);
  Mockito.when(countryService.getCountry()).thenReturn(mockCountry);

  mockMvc
      .perform(post("/api/v1/country")
	        .content(request.toString())
	        .contentType(MediaType.APPLICATION_JSON) // request
	        .accept(MediaType.APPLICATION_JSON)) // response
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.name").value("TUI"))
      .andDo(print());
}

@Test
void giveMockedCountryList_whenGetCountryConroller_theCorrect() throws Exception {
  Mockito.when(countryService.getCountries()).theReturn(Arrays.asList(new Country("ABC",120.0)))
}


 

}
