package week1;

public class Loops {
  public static void main(String[] args) {
    // Approach 1: FOR LOOP
    int i = 0;
    for (i = 0; i < 5; i++) { // count ; condition to continue ; change of i for
      System.out.println("hello_for loop");
    } // if i = 0, then sysout will run 5 times

    // Approach 2: While Loop
    i = 0;
    while (i < 5) { // condition to continue
      System.out.println("hello_while loop");
      i += 1;
    }

    // Approach 3: do-while loop
    i = 0;
    do {
      System.out.println("hello_do-while loop");
      i++;
    } while (i < 5); // condition to continue

    // for loop with break
    for (int a = 0; a < 4; a++) {
      System.out.println("a=" + a);
      if (a == 2) {
        break; // this break will exit the for loop
      }
    }

// Nested For Loop
for (int x = 0; x < 5; x++) {
  for (int y = 0; y < 5; y++) {
    System.out.println("x=" + x + ",y=" + y);
  }
}

//for (int y = 0; y < 5; y++) {
  //System.out.print("*");
//}
//System.out.println("");

/**
 * *             X=0, row=0, *
 * **            X=1, row=1, **
 * ***
 * ****
 * *****
 */

 // x = *
 // y = space

for (int x = 0; x < 5; x++) { // row
  //System.out.print("*");
  for (int y = x; y >= 0; y--) {
 System.out.print("*"); 
  }
  System.out.println(" ");
 }

 /**
 *     *
 *    ** 
 *   ***
 *  ****
 * *****
 */

 for (int x = 0; x < 5; x++) { 
  //System.out.print("*");
  for (int z = 4 - x; z >= 0; z--) {
 System.out.print(" "); 
  }
  // print *
  for (int y = x; y >=0; y--) {
    System.out.print("*"); 
  }
  System.out.println("");
 // for (int z = 0; z < 2; z++) {
 //System.out.print("*");{
 }
}
}


