package week4.ds.exceptions;

//public class Findfile {
  
//}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Findfile {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/tonyng/example.txt");
            Scanner scanner = new Scanner(file);
           System.out.println("File found!");
       } catch (FileNotFoundException e) {
           System.out.println("File not found: "); // recover
        }
    }
}
