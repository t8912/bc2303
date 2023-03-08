package week1;

import java.time.DayOfWeek;

public class DataType { // classs
  public static void main(String[] args) { // method, main
    // The variable inside a method is local variable
    // char
    char gender = 48; // ASCII 48 = 0, 90 = Z
    char gender2 = 'z';
    System.out.println(gender);
    System.out.println(gender2);

    final int DAYS_OF_A_WEEK = 7;
    // number = 1000;
    System.out.println(DAYS_OF_A_WEEK);

    int daysOfAYear = 52 * DAYS_OF_A_WEEK;
    System.out.println(daysOfAYear);

    int amount1 = 1000;
    String amount2 = String.valueOf(amount1);
    System.out.println(amount2);

    int a = 1; // primitive
    // int o; // default = 0
    Integer b = 1; // non-primitive data type (TYPE)

    a = Integer.MAX_VALUE;
    a = a + 1;
    System.out.println("a=" + a); // overflow

    int i = 20;
    byte j = (byte) i; // downgrade, byte -128 to 127, if i = 200, result: overflow
    System.out.println(j); // prints -56

    //Operator
    int X = 10;
    X = X + 1;
    X++;
    X += 1; //x = x + 1
    X -= 2; // x = x - 2
    X *= 3; // X = X * 3
    X /= 11; // X = X / 11;
    System.out.println(X); //X = 3;

    X--; // X = X - 1
    System.out.println(X); // X = 2;

    //Reminder
    int s = 10;
    int reminder = s % 3;
    System.out.println(reminder); // reminder = 1

    int counter = 0;
    System.out.println(counter); // 0
    System.out.println(++counter); // 1, execute ++ first, then println
    System.out.println(counter); // 1
    System.out.println(counter++); // 1, execute println first, then ++
    //System.out.println(counter);
    //counter++
    System.out.println(counter); // 2

  }

}
