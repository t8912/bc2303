package week5.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda2 {

  public static void main(String[] args) {
    //before Lambda
    List<Staff> staffs = Arrays.asList(new Staff("1", "John"), new Staff("2", "Mary"));
    Collections.sort(staffs, new SortStaffByid());

   // After Lambda, approach 1
   Comparator<Staff> comparator = (s1, s2) -> s1.id.compareTo(s2.id);
  // Comparator<Staff> comparator = (s1, s2) -> {
    //return s1.id.compareTo(s2.id);
  // };
   Collections.sort(staffs, comparator);


   // After Lambda, approach 2
   Collections.sort(staffs, (s1, s2) -> s1.id.compareTo(s2.id));

  }

//["Orange", "Apple, "Lemon"]

//class -> static method (swap())
//List of something as first input parameter
//functional Interface as second input parameter 

  
}
