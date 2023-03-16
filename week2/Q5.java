package week2;

import javax.swing.event.SwingPropertyChangeSupport;

public class Q5 {
  public static void main(String[] args) {

  String str = "";

  for (byte i = 127; i < 128; i++) {
    str +=i;
    if (i<0) {
      break;
    }
  }
  System.out.println(str);
}
}
