package com.codewave.demo.hktvmall.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.codewave.demo.hktvmall.model.TestObject;

@Configuration // Bean -> new AppConfig(); -> Spring context
public class AppConfig {
  
  @Bean // Object in SpringContext // The returned Object will be placed into Spring Context
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
  
@Bean // The returned Object will be placed into Spring Context
TestObject testObject1() {
  return new TestObject("John", 30);
}

@Bean // The returned Object will be placed into Spring Context
TestObject testObject2() {
  return new TestObject("Mary", 23);
}

}
