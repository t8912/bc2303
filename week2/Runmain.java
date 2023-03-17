package week2;

public class Runmain {

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

