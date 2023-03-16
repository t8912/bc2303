package week2;

public class Q2 {
  public static void main(String[] args) {
    byte hoursOfDay = 24;
    byte dayOfWeek = 7;
    byte hoursOfWeek = (byte) (hoursOfDay * dayOfWeek); (-128 + (7 * 24) + 1)
    System.out.println(hoursOfWeek);
  }
  
}
