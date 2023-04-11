package week5.optional;

import java.util.Optional;

public class Optional2 {

  public static void main(String[] args) {
    //Optional initialization approach 1 (non-null)
    Optional<String> string = Optional.of("hello");
   // Consumer -> cannot interact outside method ifPresent()
    string.ifPresent(e -> System.out.println(e));
    // noraml if then else
     if (string.isPresent()) { // no limit
      System.out.println(string.get());
     }

  //Optional initialization approach 1 (null /not null)
  Optional<String> string2 = Optional.ofNullable(null);
  Optional<String> string3 = Optional.ofNullable("bye");

  string2.ifPresentOrElse(e -> System.out.println(e), () -> System.out.println("abc"));

  string3.ifPresent(e -> System.out.println(e));

  Optional<String> string4 = Optional.empty();

  if (string4.isEmpty()) {
    System.out.println("The string is null");
  }

  if (!string4.isPresent()) {   
    System.out.println("The string is null");
  }

  String result = string3.map(e -> e + "hello").orElse("empty");
  System.out.println(result);

  Integer result2 = string4.map(e -> e.charAt(0) + "hello".charAt(0)).orElse(-1);
  System.out.println(result2);
 
  String result3 = string3.map(e -> e + "hello")//
  .filter(e -> e.endsWith("hello"))//
  .orElse("empty");
  System.out.println(result3);

  //String result = string3.map(null)

    //blackCat.ifPresent(e -> System.out.println(e.getColor()));

  }
  
}
