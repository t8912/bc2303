package week2;

  public abstract class Fashion extends Clothes {

    
    public Fashion(String color, String size, String material) {
      super(color, size, material);
    }
  
    public abstract void wear();
    
  }
   
   // public abstract void wear();


    //System.out.println("wash: The " +color + " " + material + " clothes in size " + size) ;