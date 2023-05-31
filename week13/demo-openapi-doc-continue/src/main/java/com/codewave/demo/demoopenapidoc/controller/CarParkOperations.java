package com.codewave.demo.demoopenapidoc.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewave.demo.demoopenapidoc.model.Car;
import com.codewave.demo.demoopenapidoc.model.Color;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CarParkOperations {

  @Operation(summary = "Get All Cars with a specific color", description = "Return List<Car>", tags = "Get cars")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Car.class))),
    @ApiResponse(responseCode = "404", description = "Not Found", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    @ApiResponse(responseCode = "500", description = "Internal Server Error", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  })
  @GetMapping(value = "/cars/{color}", produces = MediaType.APPLICATION_JSON_VALUE)
  List<Car> getCars(@PathVariable(name = "color") Color color);

  @Operation(summary = "Create Car and save to Static ArrayList", description = "Return Car", tags = "Post: Car")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Car.class))),
    @ApiResponse(responseCode = "404", description = "Not Found", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    @ApiResponse(responseCode = "500", description = "Internal Server Error", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  })
  @PostMapping(value = "/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Car createCar(@RequestBody Car car);
}

/* 
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewave.demo.demoopenapidoc.model.Car;
import com.codewave.demo.demoopenapidoc.model.Color;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.media.MediaType;

public interface CarParkOperations {

  @Operation(summary = "Get All Car from static ArrayList", //
  description = "Return List<Car>", //
  tags = "Get cars")

@ApiResponses(value = {
  @ApiResponses(responseCode = "200", description = "successful operation", //
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implements))

  @ApiResponse(responseCode = "404", description = "Not Foound", //
      content = @Content(mediaType = MediaType.APPLICATIOM_JSON_VALUE)),
  @ApiResponse(responseCode = "500", description = "Inteernal Server Error", //
      content = @Content(mediaType = MediaType.APPLICATIOM_JSON_VALUE)),
})

@GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
List<Car> getCars(
  @PathVariable(name = "color") Color color);

  // @GetMapping(value = "/cars")
  // List<Car> getCars();

@Operation(summary = "Create Car and save to Static ArrayList", //
    description = "Return Car", //
    tags = "Post: Car")
@ApiResponses(value = {
  @ApiResponse(responseCode = "200", description = "successful operation", //)

  @ApiResponse(responseCode = "404", description = "Not Foound", //
      content = @Content(mediaType = MediaType.APPLICATIOM_JSON_VALUE)),
  @ApiResponse(responseCode = "500", description = "Inteernal Server Error", //
      content = @Content(mediaType = MediaType.APPLICATIOM_JSON_VALUE)),
})



  @PostMapping(value = "/car")
  Car createCar(@RequestBody Car car);

  
  
}
*/