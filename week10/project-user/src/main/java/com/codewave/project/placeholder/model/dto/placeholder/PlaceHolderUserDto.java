package com.codewave.project.placeholder.model.dto.placeholder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceHolderUserDto {

  Long id;
  String name;
  String username;
  String email;
  String phone;
  String website;
  Address address;
  Company company;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Geo {
      @JsonProperty(value = "lat")
      String latitude;
      @JsonProperty(value = "lng")
      String longitude;
    }
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Company {
    String name;
    String catchPhrase;
    String bs;
  }

}
