package week5.lambda;

import java.util.Comparator;

public class SortStaffByid implements Comparator<Staff>{

  @Override
  public int compare (Staff s1, Staff s2) {
    return s1.id.compareTo(s2.id);
  }


  
}
