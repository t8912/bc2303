package week5.lambda;

@FunctionalInterface
public interface ConcatOperation {
  String compute(String a, String b);
  //void print();

  static String concat(String a, String b, ConcatOperation operation){
    return operation.compute(a, b);
  }

  public static void main(String[] args) {
    StringOperation concatByEmptyString = (a, b) -> a + b;

    StringOperation concatByComma = (a, b) -> a + "," + b;

    //StringOperation concatBySemiColon = (a, b) -> a + ";" + b;
    StringOperation concatBySemiColon = (a, b) -> {   // more than one line
      String c = a + ";" + b;
      return c;
    };
      

    System.out.println(concat("abc", "def", concatByComma));
    System.out.println(concat("Vincent", "Lau", concatBySemiColon));
    System.out.println(concat("Venturenix", "LAB", concatByEmptyString));
  }
}
