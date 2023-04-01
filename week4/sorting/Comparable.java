package week4.sorting;

import java.time.LocalDate;
//import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Comparable {
  public static void main(String[] args) {
    
Customer customer1 = new Customer(5, "Alex", LocalDate.of(2022, 2, 23));
Customer customer2 = new Customer(2, "Carl", LocalDate.of(2021, 12, 18));
Customer customer3 = new Customer(3, "Benny", LocalDate.of(2020, 3, 31));
Customer customer4 = new Customer(4, "Sally", LocalDate.of(2010, 4, 30));
Customer customer5 = new Customer(5, "Eric", LocalDate.of(2005, 1, 9));

List<Customer> customers = new LinkedList<>();
customers.add(customer1);
customers.add(customer2);
customers.add(customer3);
customers.add(customer4);
customers.add(customer5);


//System.out.println(customers);
//Collections.sort(customers);
//System.out.println(customers);

// Sort by id
//Collections.sort(customers); // comparable
//System.out.println("Sorted by id:");
//System.out.println(customers);

// Sort by joinDate
//Comparator<Customer> joinDateComparator = Comparator.comparing(Customer::getJoinDate);
//collections.sort(customers, joinDateComparator.thenComparing(Comparator.naturalOrder())); // comparators
//System.out.println("Sorted by joinDate and id:");
//System.out.println(customers);


// Sort by name
Comparator<Customer> nameComparator = Comparator.comparing(Customer::getName);
Collections.sort(customers, nameComparator); // comparators
System.out.println("Sorted by name:");
System.out.println(customers);


  }
  
}




