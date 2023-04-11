package week5.stream;

import java.util.List;

public class Person1 {
  private List<String> hobbies; // = Arrays.asList("Hiking", "Painting", "Tennis");
  private String name;

  public Person1(List<String> hobbies, String name) {
    this.hobbies = hobbies;
    this.name = name;
  }

  public List<String> getHobbies() {
    return this.hobbies;
  }

  public String getName() {

    return this.name;
  }
}
