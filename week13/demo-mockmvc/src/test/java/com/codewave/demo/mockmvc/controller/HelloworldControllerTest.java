package com.codewave.demo.mockmvc.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.codewave.demo.mockmvc.model.Country;
import com.codewave.demo.mockmvc.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest // RestController, controlleradvise, But not @service, @Repository,etc.
// @SpringBootTest // Full Load, Class Level Annotation
// @AutoConfigureMockMvc // Inject mockmvc related bean into context
@TestInstance(Lifecycle.PER_CLASS) // due to objectMapper init()
class HelloworldControllerTest {

  @Autowired
  MockMvc mockMvc; // A tool to perform api call, just like Postman

  @MockBean // To test "@Autowird" in main code (Controller autowired Service)
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

  @Test
  void testCountry() throws Exception {
    mockMvc.perform(get("/api/v1/country").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("US"))
        .andExpect(jsonPath("$.latitude").value(14.456))
        .andExpect(jsonPath("$.longitude").value(100.789))
        .andDo(print());
  }

  @Test
  void givenMockCountryService_whenUnitTestControllerGetCountry2_thenMockMvcCorrect() throws Exception {
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
  void givenMockCountryService_whenUnitTestControllerCreateCountry_thenMockMvcCorrect() throws Exception {
    JSONObject request = new JSONObject()
        .put("name", "TUI")
        .put("latitude", 123.0)
        .put("longitude", 9.0);

    Country mockCountry = objectMapper.readValue(request.toString(), Country.class);
    Mockito.when(countryService.createCountry()).thenReturn(mockCountry);

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
  void givenMockedCountryList_whenGetCountryController_theCorrect() throws Exception {
    Mockito.when(countryService.getCountries()).thenReturn(Arrays.asList(new Country("ABC", 120.02, 190.9),
        new Country("XYZ", 110.02, 90.3)));
    // Call api
    MvcResult result = mockMvc
        .perform(get("/api/v1/countries")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$..name", hasItems("XYZ", "ABC")))
        .andExpect(jsonPath("$..latitude", hasItems(110.02, 120.02)))
        .andExpect(jsonPath("$..longitude", hasItems(90.3, 190.9)))
        .andReturn();

    String content = result.getResponse().getContentAsString();

    List<Country> countries = Arrays.asList(objectMapper.readValue(content, Country[].class));
    assertThat(countries, hasSize(2));
    countries.stream().forEach(c -> {
      Assertions.assertTrue("ABC".equals(c.getName()) || "XYZ".equals(c.getName()));
    });

  }

}
