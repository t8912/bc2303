package week2;

import java.util.Random;
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    // int 1 - 100
    // Keep asking user for the input
    // user can input an integer between a range of number (1-100)
    // Bomb -> random number
    // if user input != bomb, revise the range of number
    // if user input == bomb, end game
    // Loop, until user input == bomb

    // int bomb = 47; //47, if user input 49, the range sgould be 1 - 48
    
    int input;
    int from = 1;
    int to = 100;
    Random random = new Random();
    // int bomb = new Random().nextInt(from, to);
    int bomb = random.nextInt(from, to);
    // System.out.println(bomb); // test
    int round = 1;

    do {
      // Keep asking user for the input
      Scanner scanner = new Scanner(System.in);
      System.out.println("Round " + round + "Please input a number between " + from + " -" + to);
      // user can input an integer between a range of number (1-100)
      input = scanner.nextInt(); // bug if input is Char e.g K, a or 101

      // Validation
      if (input < from || input > to) {
        System.out.println("The input number is not within range" + from + "-" + to);
        System.out.println("Please input again.");
        continue; // exit
      }
      // if user input != bomb, revise the range of number
      if (input != bomb) {
        if (input > bomb) {
          to = input - 1;
        } else {
          from = input + 1;
        }
      } 

      round++;

    } while (input != bomb); // condition to continue

    // if user input == bomb, end game
    System.out.println("Bomb!");

  }

}


