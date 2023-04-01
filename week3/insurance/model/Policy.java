package week3.insurance.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.ResolutionSyntax;

public class Policy {
 String policyNo;
 Plan planCode; // Database = CL345  ---- > enum.ValueOf
 LocalDate paidToDate;
 LocalDate effDate;
 LocalDate expiryDate;
 BigDecimal premium;
 Integer paymentMode; // 1, 3, 6, 12
 //LocalDate dateOfBirth; // belong to person
List<Coverage> coverages;

@Override
public boolean equals(Object o) {
  if (this == o) // cheecking address
  return true;
  if(!(o instanceof Policy))
   return false;  
 Policy policy = (Policy) o;
 return this.policyNo.getPolicyNo().equals(policy.getPolicyNo().getPolicyNo());
}


public Policy(PolicyNo polNo) {
  this.policyNo = polNo;
}

public static Policy of(PolicyNo polNo) {
  return new Policy(polNo);
}
public static void main(String[] args) {
  Policy pol1 = Policy.of(new PolicyNo());
  Policy pol2 = new Policy(new PolicyNo());

//replaceAll
List<String> strings = new ArrayList<>();
strings.add("Vincent LAu");
strings.add("John Lau");
strings.add("Sally Wong");
for (String s : strings) {
  String result = s.replaceAll("(.*) Lau)", "Name LAu");
  System.out.println(result);
}


}


//


}
