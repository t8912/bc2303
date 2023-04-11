package week4.ds;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Deques {

  public static void main(String[] args) {
    
    Deque<String> strings = new LinkedList<>();

    strings.add("01 Apple");
    strings.add("02 Watermelon");
    //System.out.println(strings);
    //offer -> addLast
    strings.offer("03 Banana");
    System.out.println(strings);
    

    strings.push("04 orange");
    System.out.println(strings);
    //String removed = strings.removeLast(); // exception when empty queue
    //System.out.println(strings);

    //String removed2 = strings.poll(); // no exception when empty queue
    //System.out.println(strings);   
      
    
  }

}
