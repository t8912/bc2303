package week4.sorting.pattern;

import java.time.LocalDate;
import java.util.Comparator;

import week4.sorting.Customer;

public static class CustomerSortByName implements Comparator<Customer> {


  @Override
   public int compare(Customer o1, Customer o2){
    if (o1.getName().charAt(0) == o2.getName().charAt(0)){
     if (o1.getJoinDate().isAfter(o2.getJoinDate())){
     return -1;
    }
     return 1;
  }
    return o1.getName().chartAt(0) > o2.getName().charAt(0) ? -1 : 0;
  }


}
  