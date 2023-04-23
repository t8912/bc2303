package com.codewave.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExternalResponse {
  
  School school; // "school" will appear in the response JSON

  List<Person> persons; // "persons" will appear in the response JSON

}
