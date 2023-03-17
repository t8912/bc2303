package week2;

///public class Clothes {
  //String color;
 // String size;

 // public String getColor(){
 //   return this.color;
 // }

 // public void setSize(){
 //   this.size = size;
 // }

 public class Clothes {

 private String color;
 private String size;
 private String material;

 public Clothes(String color, String size, String material) {
  this.color = color;
  this.size = size;
  this.material = material;
 }

 public String getColor(){
  return color;
 }

 public String getSize(){
  return size;
 }

 public String geMaterial(){
  return material;
 }

 public void setColor(String color) {
  this.color = color;
 }
 public void setSize(String size) {
  this.size = size;
 }
 public void setMaterial(String material) {
  this.material = material;
 }

 public void wear(){
  System.out.println("Wear: The " + color + " " + material + " clothes in size " + size) ;
 }

 public void wash(){
  System.out.println("wash: The " +color + " " + material + " clothes in size " + size) ;

 }

 public static void main(String[] args) {
 
  Clothes myClothes = new Clothes("blue", "medium", "cotton");
  
  System.out.println(myClothes.getColor());

  myClothes.setColor("red");

  myClothes.wear();

  myClothes.wash();

  ////////

  Shirt myShirt = new Shirt("blue", "medium", "cotton", "short");

  myShirt.setSleeveLength("long");

  myShirt.wear();
  myShirt.fold();

  
 }
 }

