package week5.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import week5.shapes.Circle;
import week5.shapes.Shape;
import week5.shapes.Square;

public class Stream1 {

  public static void main(String[] args) {
    //Stream(): map()
    List<String> strings = Arrays.asList("Banana", "Orange", "Apple", "Apple");
    
    Set<String> finalStrings = strings.stream() //
    .filter(s -> s.startsWith("A"))
    //.map(s -> String.valueOf(s.charAt(3)))
    .sorted()
    .collect(Collectors.toSet()); 
    System.out.println("After filter A & Sorting & toSet, Set<String>=" + finalStrings);

    //size()
   System.out.println("count=" + finalStrings.size());
   long count = strings.stream()//
   .filter(s -> s.startsWith("A"))
   .count();
   System.out.println(count);

   //distinct()
   List<String> string2 = strings.stream() //
   //.filter(s -> s.startsWith("A"))
   .distinct() // to remove the duplicated value
   .collect(Collectors.toList());
    System.out.println("After distinct(), strings=" + string2);

   List<String> limitedStrings = strings.stream()//
   .limit(2)
   .collect(Collectors.toList());
   System.out.println("stream distinct(), strings=" + string2);



    List<Shape> shapes = Arrays.asList(new Circle(5), new Square(9));
    List<BigDecimal> areas = shapes.stream() //
    .filter(s -> s.area().compareTo(BigDecimal.valueOf(80.0)) > 0)
    .map(s -> s.area())
    //.flatMap(null)
    .collect(Collectors.toList());
    System.out.println(areas);

        
  
    //List<Transaction> strings = Arrays.asList("Banana", "Orange", "Apple");
    
   // List<Transaction> finalStrings = strings.stream() //
    //.filter(s -> s.startsWith("O"))
    //.map(s -> e.getTranId)
    //.sorted()
    //.collect(Collectors.toSet()); 
    //.collect(Collect.to)


    //stream() flatmap()
    List<String> peterHobbies = Arrays.asList("Tennis");
    List<String> jasonHobbies = Arrays.asList("Hiking", "Painting"); 
    List<Person1> persons = Arrays.asList(new Person1(peterHobbies, "Peter"), (new Person1(jasonHobbies, "Jason:" ))); //
     //, (new Person1(jasonHobbies, "Jason:" ));

     List<String> hobbies = persons.stream() //
     .flatMap(person -> person.getHobbies().stream())
     .collect(Collectors.toList());

     System.out.println("stream().flatmap=" + hobbies);

     List<List<String>> stringsList = persons.stream()//
     .map(person -> person.getHobbies())
     .collect(Collectors.toList());

     System.out.println("stream().map=" + stringsList);

     // collect from List to Map
     Map<String, List<String>> hobbyMap = persons.stream()//
     .collect(Collectors.toMap(p -> p.getName(), p -> p.getHobbies()));

     System.out.println("Map=" + hobbyMap);
     System.out.println("Map.Entry=" + hobbyMap.get("Jason"));
       
  }
}
