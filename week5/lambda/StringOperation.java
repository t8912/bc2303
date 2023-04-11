package week5.lambda;

@FunctionalInterface
public interface StringOperation {
  String concat(String a, String b);
  //void print();

  static String concatString(String a, String b, StringOperation operation){
    return operation.concat(a, b);
  }

  public static void main(String[] args) {
    StringOperation concatByEmptyString = (a, b) -> a + b;

    StringOperation concatByComma = (a, b) -> a + "," + b;

    //StringOperation concatBySemiColon = (a, b) -> a + ";" + b;
    StringOperation concatBySemiColon = (a, b) -> {   // more than one line
      String c = a + ";" + b;
      return c;
    };
      

    System.out.println(concatString("abc", "def", concatByComma));
    System.out.println(concatString("Vincent", "Lau", concatBySemiColon));
    System.out.println(concatString("Venturenix", "LAB", concatByEmptyString));
  }
}
