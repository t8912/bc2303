package week4.recursion;

public class Recursion {

  public static int doSomething(int x) {
   return doSomething(x);
  }

  public static int running(int x) {
    if (x > 13) // when x = 14
    return 1;
    return running(x + 1);
  }
  // running(10), return running (11)
  // -> running(11), return running (12)
  // --> running(12), return running (13)
  // ---> running(13), return running (14)
  // ----->running(14)
  // ------->return 1;

  //input = 5, output 5+4+3+2+1
  public static int sum(int targetNumber) {
    //condition to exit
    if (targetNumber <= 1) 
    
    return targetNumber;
    return targetNumber + sum(targetNumber - 1);

  }


  // sum(5)
  // 5 + sum(4), waiting for return, 5 + ?
  // 4 + sum(3), waiting for return, 4 + ?
  // 3 + sum(2), waiting for return, 4 + ?

 // 5 + 10
 // 4 + 6
 // 3 + 3
 // 2 + 1
 // 1

 // input = 7, list=1,1,2,3,5,8,13..., output = 13

public static int num(int n) {
  if (n <=1) {
    return n;
  } else {
    return num(n-1) + num(n-2);
  }
}


  public static void main(String[] args) {
    // doSomething(2); // 1. never end, 2. never ever return 3.
    System.out.println(running(10));
    System.out.println(sum(5));
    System.out.println(num(7));
    //running(10);
  }
  
}











