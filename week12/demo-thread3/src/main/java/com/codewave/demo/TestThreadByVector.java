package com.codewave.demo;

import java.util.Vector;



public class TestThreadByVector {

    // attributes

    public static void main(String[] args) throws InterruptedException {
        // List is NOT thread-safe
        Vector<String> strings = new Vector<>(); // local Variable

        Thread thread1 = new Thread(() -> {
            // System.out.println("I am thread 1");
            // List<String> strings = new ArrayList<>();
            for (int i = 0; i < 100000; ++i) {
                strings.add("threadA"); 
                // remove array, create new array, add back old elements, add new element
            }
            System.out.println("Thread 1:"+strings.size());
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; ++i) {
                strings.add("threadB");
            }
            System.out.println("Thread 2:"+strings.size());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        //thread2.join();
        System.out.println("Finally: "+strings.size());

        long countA = strings.stream().filter(e -> e.equals("threadA")).count();
        long countB = strings.stream().filter(e -> e.equals("threadB")).count();


        System.out.println("Both Thread 1 and Thread 2 completed: " + "countA=" + countA + " countB=" + countB);
    }

}
