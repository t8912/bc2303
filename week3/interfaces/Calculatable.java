package week3.interfaces;

public class Calculatable {
  //before Java 8 (no default / static method), we call Interface 100% abstraction

  static final String SAY_HELLO = "HELLO";
  // int minValue // No attribute

  int calculate(int a, int b);

//after java8
default void show(){
  System.out.println("this is default method");
}


  default double average(List<Double> integers){
    return sum(integers) / integers.size();
  }




  default int medium(List<Integer> integers){
    Collections.sort(integers); //pass by reference (address)
    if (integers.size() % 2 ==1) {
      return integers.get(integers.size() / 2 + 1); //
    }
    return integers.get(integers.size() / 2 - 1); // even number of integers
    + integers.get(integers.size() / 2) / 2;
    }

  //default -> after Java8 (2014)
  default int sum(List<Integer> integers) {
    int total;
    for (Integer i : integers){
      total += i;
    }
    return total;
  }
}
