package week2;

import java.security.Policy;

public class Q6 {
  public static void main(String[] args) {
    
    String str = "";

    for (byte i = 127; i < 128; i++){

      if (i < 0) {
        continue;
      }
      str += 1;
    }
    System.out.println(str);
  }
  
}
//

