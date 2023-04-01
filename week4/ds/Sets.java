package week4.ds;

import java.util.HashSet;
import java.util.Set;

public class Sets {

  public static void main(String[] args) {
    Set<String> strings = new HashSet<>();

    strings.add("Tesla");
    strings.add("iPhone");
    strings.add("iPhone");

    if (!strings.contains("iPhone")){
      System.out.println("yes");
    }

    //strings.remove("Tesla"); // removed Testla

    if (strings.remove("Testla")) {
      System.out.println("remove Testla");
    }

    System.out.println(strings);

  }
  
}
