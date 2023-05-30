package com.codewave.demo;

public interface LeetCode {

  int sum(int a, int b);

  int substract(int a, int b);

  /**
   * 
   * @param nums
   * @return if empty array, return -1;
   */
  int max(int[] nums);

  /**
   * Return all capital letters from a String. For example, "aBcD", return "BD"
   * @param s
   * @return
   */
  String findCapitalLetter(String s);

}
