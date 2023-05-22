package com.codewave.demo.userdatabase.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  // @Bean
  // RestTemplate restTemplate() {
  //  return new RestTemplate();
  // }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    // objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    return objectMapper;
  }

}
