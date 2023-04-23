package week6;

import javax.sound.sampled.SourceDataLine;

public class ForLoop
  
  public static void main(String[] args) {

    public int mikssingNumber(int[] nums) {

    int n = nums.length;
    int sum = n * (n + 1) /2;
    for (int num : nums) {
      sum = sum - num;
    }
    return sum;
    System.out.println(sum);
    
  }
}
