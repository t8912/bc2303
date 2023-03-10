package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array1 {
  public static void main(String[] args) {
    int[] array = new int[3];
    array[1] = 100;
    System.out.println(Arrays.toString(array));

    int[] array2 = new int[] { 10, 20, 4, 200, };
    //String[] strArray = new String[] { "today", "tomorrow" }; // for reference

    System.out.println(Arrays.toString(array2));

    int total = 0;
    for (int e : array2) {
      if (e > 50) {
      System.out.println(e); // print 200 only
      }

      total = total + e; // come here 4 times 
    }
    // total = array2[0] + array2[1] + array2[2] + array2[3]
    System.out.println(total); // = 234 (0 + 10 + 20 + 4 + 200)

    // for (int e : array2) { // access {10, 20, 4, 200}
    // System.out.println(e);
    // }

    // Convert int array2 to a String Array
    String[] strArray = new String[array2.length];

    // for (String s : strArray) {
    // System.out.println(s);
    for (int i = 0; i < strArray.length; i++) { // counter = 4
      strArray[i] = String.valueOf(array2[i]); // new String()
    }
    System.out.println(Arrays.toString(strArray));

    //String Array List
    //Declare ArrayList of String, "Tesla", "Apple", "AWS"
    ArrayList<String> strArr = new ArrayList<>();
    strArr.add("Tesla");
    strArr.add("Apple");
    strArr.add("AWS");

    //Find the index of Apple, contains, indexOf
    int indexOfApple = strArr.indexOf("Apple");
    System.out.println("indexOfApple=" + indexOfApple);

    System.out.println(strArr.get(1)); // print Apple
    strArr.set(1, "Watermelon");
    //strArr.get
    System.out.println(strArr.get(1)); // print Watermelon

    //strArr.set(3, "Watermelon");
    strArr.remove("Tesla"); // remove string (by object), cannot remove Tesla
    strArr.remove(0); // remove index
    System.out.println(strArr);

    if (strArr.contains("Tesla")) {
      System.out.println("The list has Tesla");
    }

    if (!strArr.contains("Tesla")) { // use !, not contain Tesla
      System.out.println("The list has no Tesla");
    }

    strArr.add("Yellow");
    strArr.add("Blue");
    System.out.println(strArr);

    Collections.sort(strArr);
    System.out.println(strArr);


    //
    ArrayList<Long> longList = new ArrayList<>();
    longList.add(10L);
    longList.add(-4L);
    System.out.println(longList);

    //List<Long> longList2 = Arrays.asList(10L, -4L); // Wrong method, Solution: new arrayList
    //longList2.add(3L);
    //System.out.println(longList2);

    List<Long> longList2 = new ArrayList<>(Arrays.asList(10L, -4L)); // Wrong method, Solution: new arrayList
    longList2.add(3L);
    System.out.println(longList2);

    List<String> weekdays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    //weekdays.add("Sunday"); //THis line will cause error

    for(String s : weekdays) {
      System.out.println(s);
    }

  }
}
