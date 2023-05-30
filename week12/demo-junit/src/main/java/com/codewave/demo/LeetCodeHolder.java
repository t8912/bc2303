package com.codewave.demo;

import java.util.Arrays;

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
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > max)
        max = nums[i];
    }
    return max;
  }

  // 12321 String -> toCharArray
  // String -> charAt (good performance), Map.containsKey (bad)
  // List.contains (bad)
  // map.put, get (good)
  // indexOf() (not very fast)
  // + - / * (while, good performance)
  // % (digit /10)
  public boolean isPalindrome(int num) {
    char[] arr = String.valueOf(num).toCharArray(); //
    for (int i = 0; i < arr.length; ++i) { // i vs i +1, arr.length/2, arr.length-1
      if (arr[i] != arr[arr.length - 1 - i])
        return false;
    }
    return true;
  }

  public int maxOccurence(int[] nums) {
    // [0-9]
    // [1,1,1,2,2,3] -> 1
    // [1,2,1,2,1,3] -> 1
    int[] arr = new int[10]; // disadvantage: array size
    for (int i = 0; i < nums.length; ++i) {
      arr[nums[i]]++;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; ++i) { // arr
      if (arr[i] > max)
        max = arr[i];
    }
    return max;
  }

  /**
   * Given 2 sorted int[], return 1 sorted int[]
   * 
   * @param nums1
   * @param num2
   * @return
   */
  public int[] sortedArray(int[] nums1, int[] num2) {

  }

  public int binarySearch(int[] nums, int target) {
    // no repeat elements
    // sorted
    Arrays.sort(nums); // n log n
    // 1,1,2,3,4,5 -> target = 1
    int middleIdx = -1;
    int middle = -1;
    int max = -1;
    int min = -1;
    while (min <= max) {
      middleIdx = (max + min) / 2;
      middle = nums[middleIdx];
      if (target == middle)
        return middleIdx;
      if (target > middle)
        min = middleIdx + 1;
      if (target < middle)
        max = middleIdx - 1;
    }
    return -1;
  }

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
