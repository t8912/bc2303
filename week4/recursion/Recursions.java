package week4.recursion;

public class Recursions {
  public static int doSomething(int x) {
    return doSomething(x);
  }
  public static void main(String[] args) {
    doSomething(2); // 1. never end, 2.
  }
  
}
