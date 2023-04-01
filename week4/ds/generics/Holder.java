package week4.ds.generics;

import java.time.LocalDate;
import java.time.LocalDateTime;

import week3.insurance.model.Customer;

//compile time
public class Holder<K, V> {

K key;

V value;

public K getKey() {
  return this.key;
}

public void setKey(K key) {
  this.key = key;
}

public V getValue() {
  return this.value;
}

public void setValue (V value) {
  this.value = value;
}

public void put(K key, V value) {
  setKey(key);
  setValue(value);
}



//runtime
  public static void main(String[] args) {
   Holder<String, Integer> map1 = new Holder<>();
   map1.setKey("John");
   map1.setValue(10);
   //string.setKey("name");
   //string.setValue(10);


   //System.out.println(String.getType());

   Holder<Integer, Customer> map2 = new Holder<>();
   map2.setKey(1);
   map2.setValue(new Customer(1, "Alex", LocalDate.of(2023, 1, 23)));
   //map2.setValue(new Customer(1, "Alex", LocalDate.of(2023, 1, 23)));
   //System.out.println(integer.getType());
   //map2.put(2, new Customer(2, "Mary", LocalDate.of(2020, 2, 28)));

   //example 2 Alternative
   //CustomerContainer cc = new CustomerContainer();
   //cc.setKey(1);
   //cc.setValue.new
  }
}

