package week4.ds.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckedException {

  public static void main(String[] args) {
    try {
    Scanner scanner = new Scanner(new File("C:\\abc.txt"));
  } catch(IOException e){
    if (e instanceof FileNotFoundException) {
      System.out.println(" I'm FileNotFoundException");
    }
     
  //}catch(IOException e2) {

  }
  }
}
  

