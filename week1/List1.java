package week1;

import java.util.ArrayList; // imported library

public class List1 {
  public static void main(String[] args) {
    //ArrayList<Integer> arrayList = new ArrayList<Integer>(); // Java 1.5
    ArrayList<Integer> arrayList = new ArrayList<>(); // Java 1.5
   arrayList.add(100);
   arrayList.add(4);
   arrayList.remove(1); // remove index [100]
   System.out.println(arrayList);
   System.out.println(arrayList.size()); // size = 1
   System.out.println(arrayList.get(0));

   ArrayList<Integer> integers = new ArrayList<>();
   integers.add(5);
   integers.add(3);
   arrayList.addAll(integers);
   System.out.println(arrayList); // [100, 5, 3]


   for (Integer i : arrayList) {
    System.out.println(i);
   }

  }
  
}
