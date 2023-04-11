package week5.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Lab {
  // This example is similar to Collections.sort(), Comparator
  public static void swap(List<String> list, Swap c) {
    Objects.requireNonNull(list); // avoid null pointer
    if (!list.isEmpty()) {
      String temp = list.get(0);
      int indexToSwap = c.indexForSwap(list.size()); // call method return index for swap
      if (indexToSwap >= 0) {
        list.set(0, list.get(indexToSwap));
        list.set(indexToSwap, temp);
      }
    }
  }

  public static void main(String[] args) {
    List<String> strings = new ArrayList<>(Arrays.asList("JJJ", "AAA", "OOO"));
    // Before Lambda
    SwapHolder ss = new SwapHolder();
    Lab.swap(strings, ss);
    // After Lambda
    int i = new Random().nextInt(strings.size());
    Lab.swap(strings, x -> i); // "x -> i" is the implementation of Swap.indexForSwap(int x)
  }

}

