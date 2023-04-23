package week6;

import java.util.Arrays;
import java.util.Random;

public class MarkSix {

  public static int[] StartLuckyDraw(Selection selection) {
   return selection.select();
  }


  public static void main(String[] args) {
    //Approach 1
    MarkSix.StartLuckyDraw(new RandomSelection());
    // Approach 2
    int [] drawResult = MarkSix.StartLuckyDraw(() -> {
    int [] bag = new int [48];
    Arrays.fill(bag, 1);

    int[] result = new int[7];
    int index = 0;
    int evenIndex = 0;
    int count = 0;
    while (count < 7 ) {
      index = new Random().nextInt(48) + 1;
      evenIndex = index % 2 != 0 ? index + 1 : index;
      if (bag[evenIndex] == 1) {
        result[count] = evenIndex;
        bag[evenIndex] = 0;
        count++;
      }
    }

    return result;
     //for (int i = 0; i < 7; i++) { // counter
       //num = new Random().nextInt(48) + 1; // 
      //result[i] = num % 2 != 0 ? num + 1 : num; // get even number

      //return result;
    }); // Lambda

    int[] drawResult2 = MarkSix.startLuckyDraw(() -> {
    //return Stream.iterate(0, n -> n +2).limit(24).map(e -> e)
    return Stream.iterate(2, n -> n + 2)//
    .limit(7) //
    .mapToInt(e -> e.intValue())
    .toArray();
    
    });

   //for (int e : drawResult) {
   //System.out.println(e);
   }
  }
  

