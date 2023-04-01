package week3.insurance.model;

import java.util.List;

public abstract  class User {
  String userid;
  String password;
  //List<Policy> policy;

  public abstract void login();
}
