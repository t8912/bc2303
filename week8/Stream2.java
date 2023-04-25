import java.math.BigDecimal;

public class Stream2 {
  public static void main(String[] args) {
Stream3
    //LIST<Employee> employees = new Employee<>();
    Employee e1 = new Employee(30, "Alex", BigDecimal.valueOf(30000.00));
    Employee e2 = new Employee(35, "Sally", BigDecimal.valueOf(50000.00));
    Employee e3 = new Employee(40, "John", BigDecimal.valueOf(10000.00));

    List<Employee> employees = new ArrayList<>();

    employees.add(e1);
    employees.add(e2);
    employees.add(e3);

    Predicate<Employee> salaryLargerThan20K = e -> e.getSalary().compareTo(BigDecimal.valueOf(20000.00));

    List<Employee> result = employees.stream()
    .filter(salaryLargerThan20K) // Predicate (e -> ....)
    .map(e -> e.getNAme())
    .collect(Collectors.toList());
    //.map(null)
    
  }

  public static Predicate<Employee> getSalaryCondition() {
    return e -> e.getSalary().compareTo(BigDecimal.valueOf(20000.00));

  }

}