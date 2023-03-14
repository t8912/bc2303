package week2;

public class PassByValueReference {

  // method
  public static void doSomething(int x) {
    x = 99;
  }

  public static void doSomething(Integer x) {
    x = 99;
  }

  public static void doSomething(StringBuilder s) {
    s.append(" OK!");
  }



  
  public static void main(String[] args) {
    // PAss by Value (Scenario 1 - primitive)
    int x = 10;
    doSomething(x);
    System.out.println(x); // print 10

    // Pass by Value (Scenario 2 - Wrapper Class)
    Integer i = 10;
    doSomething(i);
    System.out.println(i); // print 10

    // Pass by Reference (Object reference)
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Java");
    doSomething(stringBuilder);
    System.out.println(stringBuilder.toString()); // Java OK!
  }
}
