package week2;

public class Q3 {
  public static void main(String[] args) {
    String str = "Welcome to programming";
    String newStr = str.replace("welcome to", "");
    char c = newStr.trim().charAt(2);
    System.out.println(c);
  }
  
}
