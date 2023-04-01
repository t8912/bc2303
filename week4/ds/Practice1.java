package week4.ds;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Practice1 {
  public static void main(String[] args) {

    List<String> strings = new ArrayList<>();
    LinkedList<String> strings2 = new LinkedList<>();
    Map<Integer, String> ht = new Hashtable<>();
    Map<Integer, String> hm = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    
    

    strings.add("hello!");
    strings.add("hi!");

    strings2.add("a");
    strings2.add("b");
    strings2.add("c");
    strings2.add("d");
    strings2.addFirst("abc");
    strings2.addLast("xyz");

    System.out.println(strings);
    System.out.println(strings2);

    ht.put(100, "White");
    ht.put(100, "blue"); // print blue
    ht.put(101, "black");
    ht.put(102, "red");

    hm.put(1, "A00");
    hm.put(2, "B00");
    hm.put(3, "C00");

    System.out.println(hm);

    System.out.println(ht);

    for (Map.Entry<Integer, String> m : ht.entrySet()) {
      System.out.println("Hashtable " + m.getKey() + " " + m.getValue());
    }

    for (Map.Entry<Integer, String> m : hm.entrySet()) {
      System.out.println("Hashmap " + m.getKey() + " " + m.getValue());
    }

    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println(" Stack example push: " + stack);
    System.out.println(" Stack example pop: " + stack);

    for (int i = 0; i < 5; i++) {
      queue.add(i);
    }
    System.out.println("Queue output " + queue);

    int removeElement = queue.remove();
    System.out.println(" remove element " + removeElement);
    System.out.println(queue);

    int head = queue.peek();
    System.out.println("head of queue " + head);

    System.out.println("removed head of queue " + queue.poll());


    //concat
    String s = "John".concat(" is a boy");


    //StringBuilder
    StringBuilder sb = new StringBuilder();
    sb.append(100.34);
    sb.append(" Please check the result.");
    System.out.println(sb.toString());

    @Override
    public String toString() {
      return new StringBuilder("[name=") //
      .append(this.name)//
      .append(", [address=")//
      .append(this.address)//
      .append("]")
      .toString();
    }


  }

}
