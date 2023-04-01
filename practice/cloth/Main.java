package week4.practice.cloth;

public class Main {
  public static void main(String[] args) {
    // Fashion.Clothes jeans = new Fashion.Clothes("Levi's", "Denim", 59.99,
    // "32x30");
    // Fashion.Shirt tshirt = new Fashion.Shirt("H&M", "Cotton", 12.99, "M",
    // "Black");

    // Fashion jeans = new Fashion("Levi's", "Denim", 59.99, "32x30");
    Fashion tshirt = new Shirt("H&M", "Cotton", 12.99, "M", "Black");

    // System.out.println("Jeans:");
    // jeans.display();

    System.out.println("\nT-Shirt:");
    tshirt.display();
  }
}
