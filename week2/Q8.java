package week2;

import java.util.ArrayList;

import week1.Array1;

public class Q8 {
  public static void main(String[] args) {
    ArrayList<Byte> bytes = new ArrayList<>();
    bytes.add((byte) 20);
    bytes.add((byte) 14);
    bytes.add((byte) 30);
    bytes.remove(1);

    int total = 0;
    for (Byte price : bytes) {
      total = price;
    }
    System.out.println("total=" + total);
    System.out.println("bytes=" + bytes);
  }
  
}
