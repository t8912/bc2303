package com.codewave.infra;

import java.util.Random;

public class WaveRandom extends Random {
/*
 * TBC.
 * 
 * @param bound given the range of numbers
 * @return [1 - bound] integer
 */
 public static int newNextInt(int bound) {
  return new Random().nextInt(bound) + 1;
 }
 
 //waveRandom.newNextInt

  //public static void main(String[] args) {
    //Random num = new Random().nextInt(48) + 1;
    //System.out.println(WaveRandom.newNextInt(3));
  //}
  
}
