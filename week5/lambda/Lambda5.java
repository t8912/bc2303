package week5.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.azul.crs.runtime.utils.PackedDataEntriesMap.Entry;

public class Lambda5 {
// forEach
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("ABC");
    strings.add("DEF");
     // Tranditional For Loop
    for (String s : strings) {

    }
    //forEach
    strings.forEach(s -> System.out.println(s));
    // we cannot use local variable declared in main method inside forEach 
   int a = 0;
   String finalString = "";
   // Imagine forEach is blackbox
   strings.forEach(s -> {
    //We don't:
    // interact the variable declared outside the forEach
    //i.e a++ / finalString + s
    
    //a++;
    //finalString +=Lambda5.concat(s);


    //We can Do:
    // usually we call void method here
    //i.e load s into Database
    //i.e send s to someone by email/sms


   });

   Map<String, Integer> ages = new HashMap<>();
   ages.put("Peter", 18);
   ages.put("Paul", 19);
   ages.put("Mary", 20);
   //Tranditional Loop
   for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
   }
   //forEach
   ages.forEach(k,v) -> {
    System.out.println(k + "," + v)
   });
    //strings.forEach(s -> System.out.println(s));
  }

  public static String concat(String s1) {
    return s1 + "c";
  }
  
}
