package com.codewave.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */

 
 
// public final class App {
//     private App() {
//     }

//     /**
//      * Says hello to the world.
//      * @param args The arguments of the program.
//      */
//     public static void main(String[] args) {
//         System.out.println("Hello World!");
//     }
// }


public class App extends Thread {

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            // System.out.println("I am thread 1");
            // List<String> strings = new ArrayList<>();
            for (int i = 0; i < 100000; ++i) {
                strings.add("something");
            }
            System.out.println("Thread 1:"+strings.size());
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; ++i) {
                strings.add("something");
            }
            System.out.println("Thread 2:"+strings.size());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        System.out.println("Finally: "+strings.size());
        System.out.println("Both Thread 1 and Thread 2 completed");
    }

}
