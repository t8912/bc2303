package week2;

public class Q4 {
  public static void main(String[] args) {
    String str = "hello";
    String newStr = "";

    if (str.length() > 5 || str.indexOf("he") == 1) {
    newStr = str;
    } else {
      newStr += "str";
    }
    System.out.println(newStr);
    }
  }
  
