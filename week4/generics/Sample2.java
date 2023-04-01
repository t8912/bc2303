package week4.generics;

public class Sample2 {


  public static<T extends Integer, S extends Double> Double sum(T t, S s){
  return t + s;
  }


  /* 
  public static<T extends Number, S extends Number> Double sum(T t, S s){
    if (t instanceof Integer) {
      Integer i = (Integer) t;
    } else if (t instanceof Byte) {
    Byte b = (Byte) t;
    } else if (t instanceof Short) {
      Short b = (Short) t;
    }else if (t instanceof Long) {

    }

    
    return (double)t + (double)s;
    }
    */

  public static void main(String[] args) {
    System.out.println(Sample2.sum(1, 3.2)); //4.2
    System.out.println(Sample2.sum((byte), 3.2f)); //4.2
    System.out.println(Sample2.sum(1, 3.2)); //4.2
    
    
  }
  
}
