package week5.lambda;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Lambda3 {

  public static void main(String[] args) {
    Printable<String> stringprinter = x -> System.out.println(x);
    stringprinter.print("something");
   // stringPrinter.print(100); // NOT OK

    Printable<Integer> integerPrintable = x -> System.out.println(x);
    integerPrintable.print(100);

    SuperPrintable superPrinter = (x, y) -> {
      if ((x.length() + y.length()) % 2 == 1) {
        return true;
      }
      return false;
    };
    //SuperPrintable s = new SuperPrintable();
    System.out.println(superPrinter.print("abc", "de")); //word's length 3 + 2
   

    SmallPrintable smallPrintable = () -> System.out.println("hello");
    smallPrintable.print(); //hello
  }
  
}
