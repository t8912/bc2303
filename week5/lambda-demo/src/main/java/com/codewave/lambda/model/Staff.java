package com.codewave.lambda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Staff {

  private String firstName;

  private Integer staffId;

  private String email;

  public Staff(String firstName, Integer staffId, String email) {
    this.firstName = firstName;
    this.staffId = staffId;
    this.email = email;

  }
 
  public String getFirstName() {
    return this.firstName;
  }

  public Integer getStaffId() {
    return this.staffId;
  }

  public String getEmail() {
    return this.email;
  }
   



  public static List<String> getAllEmail(List<Staff> staffs) {
    //Objects.requireNonNull(staffs);
    //return new ArrayList<>(Arrays.asList("-1"));
    return staffs.stream()//
    .map(e -> e.getEmail()) //
    .collect(Collectors.toList());
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
  return true;
 if (!(obj instanceof Staff)) {
  return false;
 }
 Staff staff = (Staff) obj;
  return staff.getStaffId().equals(this.getStaffId())//
  && staff.getEmail().equals(this.getEmail()) //
  && staff.getFirstName().equals(this.getFirstName());
}
}
