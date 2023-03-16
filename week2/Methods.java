package week2;

public class Methods {



  

  public static void main(String[] args) {
    //Methods methods = new Methods(); // no static
    AmountHolder amountHolder = getAmountHolder(20);
    System.out.println(amountHolder.getAmount());

  }

  public static AmountHolder getAmountHolder(int x) {
    AmountHolder amountHolder = new AmountHolder(x);
    return amountHolder;
  }
  
}
