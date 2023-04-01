package week4.ds;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

  public static void main(String[] args) {
    
    Queue<String> q = new LinkedList<>();
    q.add("red");
    q.add("Black");
    String s = q.remove();
    System.out.println(s);


    q.add("yellow");
    s = q.poll();
    System.out.println(s);
  }
  
}
