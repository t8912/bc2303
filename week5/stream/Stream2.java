package week5.stream;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
 public static void main(String[] args) {
    UnaryOperator<Integer> oddNumbers = n -> n + 2;
    List<Integer> integers = Stream.iterate(1, oddNumbers)//
        .limit(10)
        .collect(Collectors.toList());
    System.out.println(integers);

   Map<BigDecimal, BigDecimal> checkout = new HashMap<>();
   checkout.put(BigDecimal.valueOf(23.4), BigDecimal.valueOf(4.0));
   checkout.put(BigDecimal.valueOf(100), BigDecimal.valueOf(2));
   checkout.put(BigDecimal.valueOf(40), BigDecimal.valueOf(3));

  BigDecimal totalAmount = checkout.entrySet().stream() // [23.4, 4.0], [100, 2], [40, 3]
   .map (e -> e.getKey().multiply(e.getValue())) // (intermediate operation), [93.6], [200], [120]
   .filter(e -> e.compareTo(BigDecimal.valueOf(100)) > 0) // filter out 93.6
   //.max
   //.min
   //.sorted((b1, b2) -> b1.compareTo(b2) > 0 ? -1 : 1)
   .reduce(BigDecimal.valueOf(0), (t1, t2) -> t1.add(t2)); // (terminate operation) // 320
    System.out.println(totalAmount); //  100 * 2 + 40 * 3 = 320
   
   List<BigDecimal> decimals = checkout.entrySet().stream() // [23.4, 4.0], [100, 2], [40, 3]
   .map (e -> e.getKey().multiply(e.getValue())) // [93.6], [200], [120]
   .sorted((b1, b2) -> b1.compareTo(b2) > 0 ? -1 : 1)
   .collect(Collectors.toList());
    System.out.println(decimals); //  [200, 120, 93.6]
                 
  }

}
