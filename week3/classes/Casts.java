package week3.classes;

public class Casts {
  public static void main(String[] args) {
    
    int i = (int) 'c'; //ascii cod 99, this is up cast, so no need to use (int)
    System.out.println(i);

    float f = 10l; //10l is a long number, up cast to float;
    long l = (long) f; //downcasting, but be aware of data loss
    

  }
  
}
