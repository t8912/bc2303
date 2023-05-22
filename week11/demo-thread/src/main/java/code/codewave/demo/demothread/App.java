package code.codewave.demo.demothread;

import java.util.ArrayList;
import java.util.List;

public class App extends Thread {

  public static void main(String[] args) throws InterruptedException  {
    List<String> strings = new ArrayList<>();
     Thread thread1 = new Thread(() -> {
      //List<String> strings = new ArrayList<>();
      //for (int i = 0; i < 1000; ++i) {
        for (int i = 0; i < 100000; ++i) {
        strings.add("something");
      }
      System.out.println("Thread 1:"+strings.size());
     });

     Thread thread2 = new Thread(() -> {
      //List<String> strings = new ArrayList<>();
     // for (int i = 0; i < 1000; ++i) {
      for (int i = 0; i < 100000; ++i) {
        strings.add("something");
      }
      System.out.println("Thread 2:"+strings.size());
     });

     thread1.start();
     thread2.start();


     thread1.join();
     System.out.println("Finally:"+strings.size());
     System.out.println("Both Thread 1 and Thread 2 completed");
  
}
}



