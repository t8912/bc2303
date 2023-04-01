package week3.practiceweek3;

public class Shirt extends Clothes implements Wearable {

  private String sleeveLength; 

  public Shirt(String color, String size, String material, String sleeveLength){
    super(color, size, material);
    this.sleeveLength = sleeveLength;
  }

  //public class Shirt extends Clothes implements Wearable {
    public void showBrand() {
        System.out.println("This shirt is from ABC brand.");
    }
    
  @Override
  public void wear(){
    System.out.println("swim method");
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
    System.out.println("The " + getColor() + " " + " shirt in size " + getSize() + " with " + sleeveLength + " is folded.");  // add + geMaterial()
  }

 

  public static void main(String[] args) {
    
    Shirt myShirt = new Shirt("blue", "medium", "cotton", "short");

    myShirt.setSleeveLength("long");

    myShirt.wear();
    
    myShirt.fold();

    myShirt.wash();

  }
}
