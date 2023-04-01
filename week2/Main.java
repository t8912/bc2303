package week2;

public class Main {
  public static void main(String[] args) {
      Fashion.Clothes jeans = new Fashion.Clothes("Levi's", "Denim", 59.99, "32x30");
      Fashion.Shirt tshirt = new Fashion.Shirt("H&M", "Cotton", 12.99, "M", "Black");

      System.out.println("Jeans:");
      jeans.display();

      System.out.println("\nT-Shirt:");
      tshirt.display();
  }
  }
