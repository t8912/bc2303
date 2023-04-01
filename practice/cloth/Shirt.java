package week4.practice.cloth;

//public class Shirt {

//}

//public static class Shirt extends Clothes {
public class Shirt extends Clothes {
    private String color;

    public Shirt(String brand, String material, double price, String size, String color) {
        super(brand, material, price, size);
        this.color = color;
    }

    @Override
    public void display() {
        System.out.println("Type: Shirt");
        super.display();
        System.out.println("Color: " + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}