package com.codewave.demo.userdatabase.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper ModelMapper() {
    return new ModelMapper();
  }
  
}
