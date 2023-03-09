/**
 * Expected Output:
 * J
 * e
 * 3
 * 9
 * 10
 * ab c
 * VenturenixLAB, Coding
 * 19
 * ren
 * VENTURENIXLAB, JAVA
 * venturenixlab, java
 * V*NTUR*NIXLAB, JAVA!!!
 */
public class Exercise2 {
  public static void main(String[] args) {
    String str = "VenturenixLAB, Java";

    // Use int name.charAt()
    System.out.println(str.charAt(15));// prints J
    System.out.println(str.charAt(1));// prints e

    // Use int indexOf(int ch), or int indexOf(String ch)
    System.out.println(str.indexOf("t"));// prints 3
    System.out.println(str.indexOf("x"));// prints 9
    System.out.println(str.indexOf("L"));// prints 10

    // Use String trim()
    String abc = "    ab c    ";
    System.out.println(abc.trim());// prints "ab c"

    // Use String replace() method
    System.out.println(str.replace("Java", "Coding"));// prints VenturenixLAB, Coding

    // int length()
    System.out.println(str.length());// prints 19

    // Use String substring(int start, int end)
    System.out.println(str.substring(5, 8));// prints "ren"

    // String toLowerCase(), and String toUpperCase()
    System.out.println(str.toUpperCase()); // print "VENTURENIXLAB, JAVA"
    System.out.println(str.toLowerCase());// prints "venturenixlab, java"

    // Method Chaining, replaceAll(), toUpperCase(), concat()
    System.out.println(str.replaceAll("e", "*").toUpperCase().concat("!!!")); // prints "V*NTUR*NIXLAB, JAVA!!!"

  }
}