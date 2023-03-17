package week2;

public class Shirt extends Clothes {

  private String sleeveLength; 

  public Shirt(String color, String size, String material, String sleeveLength){
    super(color, size, material);
    this.sleeveLength = sleeveLength;
  }

  @Override
  public void wash() {
   System.out.println("@Override - Wash");
  }

  public String getSleeveLength(){
    return sleeveLength;
  }

  public void setSleeveLength(String sleeveLength){
    this.sleeveLength = sleeveLength;
    //return sleeveLength;
  }
  public void fold(){
    System.out.println("The " + getColor() + " " + geMaterial() + " shirt in size " + getSize() + " with " + sleeveLength + " is folded.");
  }

 

  public static void main(String[] args) {
    
    Shirt myShirt = new Shirt("blue", "medium", "cotton", "short");

    myShirt.setSleeveLength("long");

    myShirt.wear();
    
    myShirt.fold();

    myShirt.wash();

  }
}
