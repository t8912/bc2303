import java.math.BigDecimal;

public class Employee {
private int age;
  private String name;
  private BigDecimal salary;

  public Employee(){

  };

  public Employee(int age, String name, BigDecimal salary){
    this.age = age;
    this.name = name;
    this.salary = salary;
  }
  
  public int getAge(){
    return this.age;
  }
  public String getNAme(){
    return this.name;
  }

  public BigDecimal getSalary() {
    return this.salary;
  }
  
}
