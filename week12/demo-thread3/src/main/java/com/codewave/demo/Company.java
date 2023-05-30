package com.codewave.demo;

public class Company {

  static int stockCount = 5000;

  synchronized public void getPizza() {
    for (int i = 0; i < 3; ++i) {
      System.out.println(i);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }
  

  synchronized public void deductStock() {
    for (int i = 0; i < 1000; ++i) {
     // stockCount--; // thread-safe
     stockCount = stockCount - 1; // thread-safe
    }
   }
}