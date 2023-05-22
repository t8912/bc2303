package com.codewave.project.placeholder.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.ProjectUserApplication;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class BeanController {

  @GetMapping(value = "/beans")
  @ResponseStatus(value = HttpStatus.OK)
  public List<String> getAllBeans() {
    return ProjectUserApplication.getContextBeans().stream()
        .sorted()
        .collect(Collectors.toList());
  }

}
