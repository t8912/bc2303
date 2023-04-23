package week7.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
  public static void main(String[] args) {
    int[] i1 = new int[] { 3, 10, 14 };
    int[] i2 = new int[3];
    int[] i3 = Arrays.copyOf(i1, i1.length); // create a new object in Heap

    i2 = i1; // change the reference of i2, so i1 and i2 point to the same object now
    i1[1] = 3;
    System.out.println(i2[1]); // i1[1] -> 3
    System.out.println(i3[1]); // 10
    //i2 = Arrays.copyOf(i1, i1.length); // create a new object in Heap

    //i1[1] = 3;
    // i2 = ?

    //Examp[le 2
    //[[1, 2, 3 ], [ 3, 5, 6 ]]
    List<List<String>> stringlists = new ArrayList<>(new ArrayList<>());
 
    List<String> strings2 = new ArrayList<>();
    strings2.add("Red");
    strings2.add("Yellow");

    List<String> strings3 = new ArrayList<>();
    strings3.add("White");
    strings3.add("Black");

    stringlists.add(strings2); // [["Red", "Yellow"]]
    stringlists.add(strings3); // [["Red", "Yellow"], ["White", "Black"]]

    strings3.set(1, "Blue"); // Black -> Blue

    for (List<String> strings : stringlists) {

      System.out.println(strings);

    }


    //Example 3
    List<String> strs = new ArrayList<>();
    String str = "hello";
    strs.add(str);
    str = "bye";
    System.out.println(strs); //hello

  }
  
}
