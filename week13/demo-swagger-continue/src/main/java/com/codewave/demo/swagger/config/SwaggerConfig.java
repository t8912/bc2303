package com.codewave.demo.swagger.config;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

@Bean
	public Docket methodNameNotImportant() {
    ApiInfo apiInfo = new ApiInfoBuilder()
    .title("Bootcamp codewave API")
    .description("Bootcamp codewave API reference for developers")
    .termsOfServiceUrl("http://javainuse.com")
    .contact("javainuse@gmail.com")
    .license("Bootcamp License")
    .licenseUrl("javainuse@gmail.com")
    .version("1.0")
    .build();

	Predicate<String> paths = regex("/currencies.*");

		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo).select().paths(paths).build();
	
  }
}
  
  
  
 