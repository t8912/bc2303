import java.util.Arrays;
import java.util.Scanner;

public class Exercise8 {

  public static void main(String[] args) {

    int[] my_array = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };

    Scanner input = new Scanner(System.in);

    System.out.print("Input an Index Position: ");
    int Index_position = input.nextInt();

    System.out.print("Input a new Value: ");
    int newValue = input.nextInt();

    System.out.println("Original Array : " + Arrays.toString(my_array));

    // Shift elements to the right from the specified index position
    for (int i = my_array.length - 2; i >= Index_position; i--) {
        my_array[i+1] = my_array[i];
    }

    // Insert new value at the specified index position
    my_array[Index_position] = newValue;

    System.out.println("New Array: " + Arrays.toString(my_array));
  }
}

