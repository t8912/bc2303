package week1;

public class Helloworld {
  // shortcut: main
  public static void main(String[] args) {
    // primitive data type
    // int stand Integer, can -ve or +ve
    double age = 23 - 0.4; // double Operation Error (Relate to Mem)
    age = age + 10;
    age = age + (9 - 11) * 2 / 10; //
    age = age * 2 / 10; //

    // long -> integer
    long amount = 1000;
    amount = 1000 * 10;

    // char
    char a = ' ';
    char gender = 'F'; // exception char gender = 123;

    // naming convertion, caml-case
    double ageWithDp = 23.3;
    double Tony = 23; // -> 23.0
    boolean isCompleted = true; // true, false

    // non-primitive data type
    String str = "qazwsx edcrfv 123\n\"";
    String str1 = "123abc";
    String str2 = "456def";
    String str3 = str1 + str2 + "hello";

    // Object
    System.out.println(age);
    System.out.println(ageWithDp);
    System.out.println(Tony);

    Tony = 25;

    System.out.println(Tony);
    System.out.println(isCompleted);
    System.out.println(str);
    // shortcut: sysout
    System.out.println(isCompleted + " space" + str);
    System.out.println("str=" + str);
    System.out.println("Tony" + " " + Tony);
    System.out.println(str3);
    System.out.println(age);
    System.out.println(amount);
    System.out.println(gender);
    System.out.println(a);
    System.out.println("Hello World!! 你好嗎");
    System.out.println("Hello World!! 你好嗎");
    System.out.println("Hello World!! 你好嗎");
  }
}
