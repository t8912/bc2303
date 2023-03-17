package week3.classes;

public class Student extends Person {

  int year;

  public Student () {
    
  }

  public Student(double height, double weight, int year) {
    super(height, weight);
    this.year = year;
  }

  @Override
  public void swim(){
    System.out.println("swim method");

  }
  
  @Override
  public void walk(){

  }
  @Override
  public void sleep() {

  }

    public static void main(String[] args) {

      Student student = new Student(170.8, 70.0, 2);
      student.sleep();
      student.walk();
      student.swim();
      
    }
    
  }

