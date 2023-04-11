package week5.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;



public class Lambda4 {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
  
    Function<String, Integer> function = s -> s.length();
     //map.put("Mary", "Mary".length()); // "Mary".length() is result
    Integer output = map.computeIfAbsent("Peter", function); // function is a formula .....
     System.out.println(output);

    map.computeIfAbsent("Peter", function);

    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }


    Function<Integer, Integer> function3 = x -> x;

    Login<Integer> login = x -> 2;
  }
  
}


