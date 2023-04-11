package week5.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import week2.Cat;

public class Stream3 {

  public static void main(String[] args) {
    Cat cat = new Cat("Red", "Mary", "10.4");
    Cat cat2 = new Cat("Yellow", "Sally", "5.2");

    //List<Cat> cats = new ArrayList<>();
    //stream(), map(), color -> List<String>


    List<Cat> cats = new ArrayList<>();
    cats.add(cat);
    cats.add(cat2);

    List<String> colors = cats.stream() //
                             .map(e -> e.getColor()) //
                             .filter(e -> e.startsWith("")) //
                             .collect(Collectors.toList());
                
                             

    System.out.println(colors);
  }
  
}
