package week2;

import javax.sound.sampled.SourceDataLine;
import javax.swing.event.SwingPropertyChangeSupport;

public class Test {

public static int sum(int[] nums) {
  int sum = 0;
  for (int num : nums) {
    sum += num;

  }
  return sum;
}
}

public static int sum(int... nums) {
  int sum = 0;
  for (int num : nums) {
    sum += num;

  }
  return sum;
}

System.out.println(sum(1, 2, 3, 4, 5));



  
  

