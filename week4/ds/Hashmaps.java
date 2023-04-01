package week4.ds;

import java.util.HashMap;
import java.util.Map;

public class Hashmaps {

  public static void main(String[] args) {
    HashMap<String, String> hashMap = new HashMap<>();// O(n)
    // new HashMap<>();
    // -> Array of LinkedList
    // -> One Map.Entry = one element of the array
    // -> so, new HashMap<>() -> LinkedList []
    // -> LinkedList[0] = new LinkedList();
    // for loop to initialize LinkedList90 and new LinkedList to be assigned
    hashMap.put("name", "John");
    hashMap.put("age", "18");
    hashMap.put("name", "Mary"); //replace, due to same key
    hashMap.put("apple-website", "www.apple.com");
    System.out.println(hashMap);
    System.out.println(hashMap.get("name")); // Mary
  
    System.out.println(hashMap.get("apple-website")); //www.apple.com
    System.out.println(hashMap.containsKey("name")); // true
    System.out.println(hashMap.containsKey("Mary")); // false
    System.out.println(hashMap.containsValue("Mary"));//true
  
   for (Map.Entry<String, String> entry : hashMap.entrySet()){
   System.out.println(entry);
  }

  }
  
}
