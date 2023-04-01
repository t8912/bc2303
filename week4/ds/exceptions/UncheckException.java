package week4.ds.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UncheckException {

public static double divide(double a, double b) throws ArithmeticException {
  //unchecked
  //if (b == 0) {
  // return -1.0;
  //}
  return a / b; //unchecked
}

public static void caller2() {
  try {
    divide (10, 0);
  } catch (ArithmeticException e) {
    return -1;
  }
}



public static void scanFile(String filePath) throws FileNotFoundException {
Scanner scanner = new Scanner(new File(filePath));
//Checked Exception handling:
// Approach 1: try {} catch {}
// Approach 2: method signature throws that exception
}

public static  void caller() {
  //I'm caller, but there are still 2 approaches to choose.
  try {
    scanFile("C:\\abc.txt");
  } catch (FileNotFoundException e) {
//recover action skip finding the file
  }
  
}

  public static void main(String[] args) {
    int noOfPeople = 0;
    int totalAmount = 1000;
    
    try {
      double average = totalAmount / noOfPeople; // /0
    } catch (ArithmeticException e){

    }

    double 
   if (noOfPeople == 0) {
    average2 = -1;
   } else{
    double average2 = totalAmount / noOfPeople;
   }
   


    try {
      Integer integer = null;
      int x = integer.intValue(); // hit error and go to catch block, skip sysout
      System.out.println(x);
    }catch (NullPointerException e) {

    }
    

  }
  
}
