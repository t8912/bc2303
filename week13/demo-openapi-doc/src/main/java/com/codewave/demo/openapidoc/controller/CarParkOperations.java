package com.codewave.demo.openapidoc.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.openapidoc.model.Car;
import com.codewave.demo.openapidoc.model.Color;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface CarParkOperations {

  @Operation(summary = "Get All Cars from Static ArrayList", //
      description = "Return List<Car>", //
      tags = "Get: Cars")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Car.class))),
      @ApiResponse(responseCode = "400", description = "Not Found", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
      @ApiResponse(responseCode = "500", description = "Internal Server Error", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
  })
  @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
  List<Car> getCars();

  @Operation(summary = "Get All Cars by Color", //
      description = "Return List<Car>", //
      tags = "Get: Cars, By Color")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Car.class))),
      @ApiResponse(responseCode = "400", description = "Not Found", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
      @ApiResponse(responseCode = "500", description = "Internal Server Error", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
  })
  @GetMapping(value = "/cars/color/{color}", produces = MediaType.APPLICATION_JSON_VALUE)
  List<Car> getCars(
      @Parameter(name = "color", description = "enum Color.class", required = true) @PathVariable(value = "color") Color color);

  @Operation(summary = "Create Car and save to Static ArrayList", //
      description = "Return Car", //
      tags = "Post: Car")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Car.class))),
      @ApiResponse(responseCode = "404", description = "Not Found", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
      @ApiResponse(responseCode = "500", description = "Internal Server Error", //
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
  })
  @PostMapping(value = "/car")
  Car createCar(
      @Parameter(description = "Create a Car", required = true, //
          schema = @Schema(implementation = Car.class)) @Valid @RequestBody Car car);

}
