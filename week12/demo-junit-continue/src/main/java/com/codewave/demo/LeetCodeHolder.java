package com.codewave.demo;

public class LeetCodeHolder implements LeetCode {

  @Override
  public int sum(int a, int b) {
    return a + b;
  }

  @Override
  public int substract(int a, int b) {
    return a - b;
  }

  @Override
  public int max(int[] nums) {
    if (nums.length <= 0)
    throw new IllegalArgumentException();
    
    int max = Integer.MIN_VALUE; 
    for(int i = 0; i < nums.length; ++i) {
      if (nums[i] > max)
      max = nums[i];
    }
    return max;
  }


 //12321 String -> toCharArray / toCharAt
 //String -> get > charAt

 /*
  * Given 2 sorted int [], return 1 sorted int[]
  */




@Override
public String findCapitalLetter(String s) {
  if (s == null)
  throw new IllegalArgumentException();
  StringBuilder builder = new StringBuilder();
  char c;
  for (int i = 0; i < s.length(); ++i) {
    c = s.charAt(i);
    if (Character.isUpperCase(c))
    builder.append(c);
  }
  return builder.toString();
}
}





