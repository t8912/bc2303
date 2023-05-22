package com.codewave.demo.hktvmall.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

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
    String stree;
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
  public class Company{
    String name;
    String catchPhrase;
    String bs;
  }
}

/*
 * import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  
}


{
  "id": 1,
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
},
 */
