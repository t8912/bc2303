package week2.ds;

import java.util.ArrayList;

public class List2 {
  public static void main(String[] args) {
    
    ArrayList<Integer> integers = new ArrayList<>();
    integers.add(23);
    integers.add(-100);

    integers.remove(1); //remove 2nd position of the List
    System.out.println(integers);

    ArrayList<String> strings = new ArrayList<String>();

    strings.add("Hello");
    strings.add("World");
    strings.add("Java");

    strings.lastIndexOf("World");

    System.out.println(strings.lastIndexOf("World"));
    String[] strs = (String[]) strings.toArray();

     //stringList.get(0);
     //System.out.println(stringList.lastIndexOf("World"));

     for (String s : strings) {
      System.out.println(s);
     }

     strings.forEach(s -> System.out.println(s));

     strings.forEach(s -> {
      System.out.println(s);
      System.out.println(s + s);
     });
  }
  
}

