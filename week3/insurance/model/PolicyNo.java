package week3.insurance.model;

//import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;

public class PolicyNo {

  private String policyNo;


  public static final String noPrefix = "POL";

  private static String yyyymmdd = "";

  private static int polNoCnt = 0; 

  public PolicyNo() {
    this.policyNo = noPrefix + genPolicyNo();
  }

  public String getPolicyNo() {
    return this.policyNo;
  }

  public String genPolicyNoString() {
    return String.valueOf(genPolicyNo());
  }

  public long genPolicyNo() {
  // YYYYMMDD000000
  // 20231211
  
  LocalDate currenDate = LocalDate.now();

  
  String yearMonDay = "" + currenDate.getYear()//
   + String.format("%02d", currenDate.getMonthValue())
   + String.format("%02d", currenDate.getDayOfMonth());

   long addTailZero = Long.valueOf(yearMonDay) * 1000000;
   //System.out.println(addTailZero); 

   if (!yearMonDay.equals(yyyymmdd) && !"".equals(yyyymmdd)){
    //reset counter
    polNoCnt = 0;
    yyyymmdd = yearMonDay;
   }

   System.out.println(yearMonDay);
   polNoCnt++;

   long result = addTailZero + polNoCnt++;

  return result;
  }
  public static void main(String[] args) {
    PolicyNo pol = new PolicyNo();
    PolicyNo pol1 = new PolicyNo();  

  }
}


/*
 * The code is defining a class `PolicyNo` with a method `generatePolicyNo()` that generates a unique policy number based on the current date and a counter. Here's a breakdown of how the method works:

1. `LocalDate currenDate = LocalDate.now();`: This line creates a `LocalDate` object that represents the current date.

2. `String yearMonDay = "" + currenDate.getYear() + String.format("%02d", currenDate.getMonthValue()) + String.format("%02d", currenDate.getDayOfMonth());`: This line creates a string `yearMonDay` that concatenates the year, month, and day of the current date. The `String.format()` method is used to ensure that the month and day are zero-padded to two digits.

3. `long addTailZero = Long.valueOf(yearMonDay) * 1000000;`: This line creates a long `addTailZero` by converting the `yearMonDay` string to a long and multiplying it by one million.

4. `if (!yearMonDay.equals(yyyymmdd) && !"".equals(yyyymmdd)){ polNoCnt = 0; yyyymmdd = yearMonDay; }`: This `if` statement checks if the `yearMonDay` string is different from a previously generated policy number `yyyymmdd`. If it is, it resets the policy number counter `polNoCnt` and updates `yyyymmdd` to the new date.

5. `System.out.println(yearMonDay); polNoCnt++;`: This line prints the `yearMonDay` string to the console and increments the policy number counter `polNoCnt`.

6. `long result = addTailZero + polNoCnt++; return result;`: This line creates a long `result` by adding `addTailZero` and the post-incremented value of `polNoCnt`. The new policy number is returned as the result of the method.

7. Finally, the `main()` method creates two instances of the `PolicyNo` class, but doesn't call the `generatePolicyNo()` method, so nothing is printed to the console.
 */

  