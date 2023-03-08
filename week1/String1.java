package week1;

public class String1 {
  public static void main(String[] args) {
    String name = " Today is a nice day "; // test - not include space or include space
    // name = "a"; assignment
    int index = 100;

    System.out.println("hello");
    System.out.println(name.charAt(0)); // index 0 represents the 1st position
    // System.out.println(name.charAt(100));
    // System.out.println(name.charAt(index));

    System.out.println(name.indexOf("a")); // print 4
    System.out.println(name.indexOf("Nice")); // print -1
    System.out.println(name.indexOf("nice")); // print 12
    System.out.println(name.indexOf(" ")); // print 5 (before - not include space), print 0
    System.out.println(name.trim()); //
    System.out.println(name.replace("Today", "Tomorrow"));
    // System.out.println(name.replaceAll(name, name));

    System.out.println(name.length()); // 21 , 19
    System.out.println(name.substring(1, 3)); // start from index 1, end before index 3

    System.out.println(name.toUpperCase());
    System.out.println(name.toLowerCase());

    String newString = name.concat(", but raining.");
    String finalString = newString.toUpperCase();
    System.out.println(finalString);

    System.out.println(name.concat(", but raining.").toUpperCase());

    int a = 10;
    if (a == 10) {
      System.out.println("");
    }

    String firstName = "John";
    if ("John".equals(firstName)) { // the best way to compare String
      System.out.println("They are equal");
    } else {
      System.out.println("They are not equal");
    }

    String str = "brown";
    // String myString = "The " + "quick " + str + " fox..."; //expensive
    // System.out.println("The quick brown fox..." == myString); // false
    // System.out.println("The quick brown for...".equals(myString)); // false

    String myString = "The " + "quick " + "brown" + " fox...";
    System.out.println("The quick brown fox..." == myString); // true
    System.out.println("The quick brown fox...".equals(myString)); // true

    // int ->
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);

    if (i1 == i2) {
      System.out.println("They are the same oject in Heap");
    } else {
      System.out.println("They are not the same object in Heap"); // print here
    }
    // System.out.println(i1.compareTo(i2));
    if (i1.compareTo(i2) == 0) {
      System.out.println("They have equal value");
    } else {
      System.out.println("They are not having equal value");
    }

    // Wrapper Class limition, -128 to 127
    Integer d1 = 127;
    Integer d2 = 127;
    Integer e1 = 128;
    Integer e2 = 128;
    if (d1 == d2) {
      System.out.println("d1 = d2");
    } else {
      System.out.println("d1 != d2");
    }
    if (e1 == e2) {
      System.out.println("e1 = e2");
    } else {
      System.out.println("e1 != e2");
    }

    // Unboxing
    // int i = 1;
    int i = new Integer(1); // unboxing
   


    // Autoboxing
    Integer integer = 128; // new Integer(128) , auto new Integer
    Integer integer2 = 127; // find if there is existing object with value 127, if yes, find the same object

    //
    int y = Integer.valueOf(1); // new Integer (1)
    boolean bool = Boolean.valueOf(true); // new Boolean(true)

    Double double2 = new Double(10.98);
    Float float2 = new Float((float) 10.98);

   Character char3 = new Character('a');
   Character c2 = 'a'; //autoboxing

      
  }
}
