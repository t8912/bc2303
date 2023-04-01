package week4.practice.cloth;

//public class Clothes {

//}

//public static class Clothes extends Fashion {

public class Clothes extends Fashion {
    private String size;

    public Clothes(String brand, String material, double price, String size) {
        super(brand, material, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Material: " + material);
        System.out.println("Price: $" + price);
        System.out.println("Size: " + size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}