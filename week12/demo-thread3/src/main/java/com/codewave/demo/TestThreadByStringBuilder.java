package com.codewave.demo;


public class TestThreadByStringBuilder {

    // attributes

   static StringBuilder builder = new StringBuilder("");

    public static void main(String[] args) throws InterruptedException {
    //     // List is NOT thread-safe
    //     List<String> strings = new ArrayList<>(); // local Variable

        Thread thread1 = new Thread(() -> {
            // System.out.println("I am thread 1");
            // List<String> strings = new ArrayList<>();
            for (int i = 0; i < 100000; ++i) {
                builder.append("A"); 
                // remove array, create new array, add back old elements, add new element
            }
            //System.out.println("Thread 1:"+ longString.size());
        });

     


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; ++i) {
                builder.append("B"); 
            }
            //System.out.println("Thread 2:"+ longString.size());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        //thread2.join();
        System.out.println("Finally: "+ builder.length());
       // System.out.println("Both Thread 1 and Thread 2 completed");
    }

}
