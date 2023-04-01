package week4.practice.cloth;

//public class Fashion {

//}

public abstract class Fashion {
    protected String brand;
    protected String material;
    protected double price;

    public Fashion(String brand, String material, double price) {
        this.brand = brand;
        this.material = material;
        this.price = price;
    }

    public abstract void display();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
