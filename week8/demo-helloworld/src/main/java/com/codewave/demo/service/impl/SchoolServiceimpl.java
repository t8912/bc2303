package com.codewave.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewave.demo.model.School;
import com.codewave.demo.service.SchoolService;

@Service
public class SchoolServiceimpl implements SchoolService {
  @Override
  public List<School> getSchools() {
    School s1 = School.builder()
    .name("ABC College")
    .build();
    School s2 = School.builder()
    .name("DEF College")
    .build();
    return Arrays.asList(s1, s2);

  }
  
}
