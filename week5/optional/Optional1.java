package week5.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import week2.Cat;

public class Optional1 {
  public static void main(String[] args) throws Exception {
    Cat cat = new Cat("Red", "Mary", "10.4");
    Cat cat2 = new Cat("Yellow", "Sally", "5.2");

    List<Cat> cats = new ArrayList<>();
    cats.add(cat);
    cats.add(cat2);

    boolean hasRedCat = cats.stream().anyMatch(e -> "Red".equals(e.getColor()));
    if (hasRedCat) {
      System.out.println("Contain Red Cat");
    }

    Cat redCat = cats.stream() //
        .filter(e -> "Red".equals(e.getColor())) //
        .findFirst() //
        .orElseThrow(() -> new AnimalNotFoundException("Red Cat is not found"));

    Optional<Cat> blackCat = cats.stream() //
        .filter(e -> "Black".equals(e.getColor())) //
        .findFirst();

    blackCat.ifPresent(e -> System.out.println(e.getColor()));

    blackCat.ifPresentOrElse(e -> System.out.println(e.getColor()), //
        () -> System.out.println("No Black Cat"));

    Cat bCat = blackCat.orElseGet(() -> new Cat("Black", "Joe", "20.7"));

    System.out.println(bCat);

  }
}


/*
 * import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import week2.Cat;

public class Optional1 {

  public static void main(String[] args) {
    
    Cat cat = new Cat("Red", "Mary", "10.4");
    Cat cat2 = new Cat("Yellow", "Sally", "5.2");

    List<Cat> cats = new ArrayList<>();
    cats.add(cat);
    cats.add(cat2);

    boolean hasRedCat = Casts.stream().anyMatch(e -> "Red".equals(e.getColor()));
    if (hasRedCat) {
      System.out.println("Contain Red Cat");
    }

    //Optional<Cat> redCat = cats.stream().filter(e -> "Red".equals(e.getColor())) //
    Cat redCat = cats.stream()
    .filter(e -> "Red".equals(e.getColor())) //
    .findFirst(); //
    //.orElse(new Cat());
    .orElseThrow(() -> new AnimalNotFoundException("Red Cat is not found"));

    Optional<Cat> blackCat = cats.stream()//
    .filter(e -> "Black".equals(e.getColor())) //
    .findFirst();

    blackCat.ifPresent(e -> System.out.println(e.getColor()));

    blackCat.ifPresentOrElse(e -> System.out.println(e.getColor()), //
    () -> System.out.println("No Black Cat"));

    Cat bCat = blackCat.orElseGet(() -> new Cat("Black", "Joe", "20.7"));
    
   
    System.out.println(bCat);
  }
  
}


 */
