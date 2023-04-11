package week5.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExercise {

  public static void main(String[] args) {
    // define a formula

    // function Interface

    // make use of the formula

    //////////////////////
    // Define a formula as a lambda expression
    Function<Integer, Integer> function = x -> x * 2;

    // Use the formula to calculate the output for a given input
    // int input = 4;
    int output = function.apply(10);

    // Print the input and output
    // System.out.println("Input: " + input);
    System.out.println("Output: " + output);

    /////////////////////

    Function<String, Boolean> function2 = s -> {
      if (s.length() == 5) {
        return true;
      }
      return false;
    };
    function2.apply("hello");

    BiFunction<String, Integer, Integer> asciiOfCharAtIndex = (s, i) -> {
      // "John" -> "J"
      // "Mary" -> "M"
      return (int) s.charAt(i);
    };

    System.out.println(asciiOfCharAtIndex.apply("Mary", 2)); // 114, ascii of "r"

    // Define a formula as a lambda expression // define Two String input and return
    // sum of their length as an integer (output)
    BiFunction<String, String, Integer> lengthSumFunction = (s1, s2) -> s1.length() + s2.length();

    // Use the formula to calculate the output for a given input
    String input1 = "Hello";
    String input2 = "Java";
    int output2 = lengthSumFunction.apply(input1, input2);

    // Print the input and output
    System.out.println("Input 1: " + input1);
    System.out.println("Input 2: " + input2);
    System.out.println("Output: " + output2); // Output: 9

  }

}
