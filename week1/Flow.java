package week1;

public class Flow {
  public static void main(String[] args) {
    int a = 0;

    // In this scenario, Line 8 -> 10 -> 12 -> 13 -> 15
    if (a + 1 > 2) { // >, <, <=, >=
      System.out.println("hello");
    } else if (a + 1 == 2) { // = mens assignment , == means check if they are equal
      System.out.println("Code");
    } else if (a + 1 < 2) {
      System.out.println("yeah");
    }
    // End the if flow

    long b = 100;
    boolean isFemale = true;

    // b== 100, asking you if b equals to 100 -> YES
    // isFemale == false, asking you if isFemale equals to false? -> NO
    // Flow: Line 23 -> 25 -> 26
    if (b == 100 && isFemale == false) { // && means AND
      System.out.println("hello");
    } else {
      System.out.println("code");
    }

    if (b == 100 || isFemale == false) { // || means OR
      System.out.println("yes");
    }

    if (b == 99 || isFemale == true && b + 2 > 101) { // && will execute before ||
      System.out.println("yes");
    }

    if ((b == 99 || isFemale == true) && b + 2 > 101) { // || will execute before &&
      System.out.println("yes");
    }

    boolean o = false;
    if (o == false) {
      System.out.println("hello");
    }
    if (!o) { // !o, asking you if o equals to false
      System.out.println("No");
    }

    int numericGrade = 60;
    char letterGrade = ' ';

    switch (numericGrade) {
      case 90: {
        letterGrade = 'A';
        break;
      }
      case 80: {
        letterGrade = 'B';
        break;
      }
      case 70: {
        letterGrade = 'C';
       break;
      }
      case 60: {
        letterGrade = 'D';
        // System.out.println(letterGrade);
       break;
      }
      case 50: {
        letterGrade = 'E';
        break;
      }
      default:{
        letterGrade = 'F';
       break;
      }
    }
    System.out.println("letterGrade: " + letterGrade);
  }
}
