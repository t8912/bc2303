package week6;

import java.util.Stack;

public class Char1 {

  public void reverseString(char[] s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s ){
      stack.push(c);
      System.out.println(c);
    }

   

  
}
}