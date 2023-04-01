package week4.generics;

import java.util.ArrayList;
import java.util.List;

import week1.Array1;

public class Sample<T extends Integer, S extends Double> {

T t;
S s;

public static <T, S> Double sum(T t, S s){
  return (Double) s + (Integer) t; 
}


public static void main(String[] args) {
  List list = new ArrayList<>();
  list.add(new Double(1.0));
  list.add("customers");
  list.add(new Integer(99));


  //List<String> str = new ArrayList<String>();

  
  Sample<Integer, Double> s = new Sample<>();
  
   System.out.println(Sample.<Integer, Double>sum(1, 3.0d));
   System.out.println(Sample.sum(1, 3.0d));
   //Sample.<Integer, Double>sum(1, 3.0);


}
}
  

  

  

