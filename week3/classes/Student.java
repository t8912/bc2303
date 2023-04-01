package week3.classes;

public class Student extends Person implements Calculatable {

  //Attributes
  int year;

  //Constructor
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

  public String completelyNewMethod(){
    return "";
  }

  @Override
  public void sound(){
    System.out.println("Wei Wei");
  }

  @Override
  public int calculate (int x, int y) {
    return x + y;
  }

@Override
public String toString(){
  return "[" + "year" + this.year //
  + "," + "height=" +super.getHeight()
  + "," +"height=" +super.getWeight() //
  + "]";
}


    public static void main(String[] args) {

      Student student = new Student(170.8, 70.0, 2);
      student.sleep();
      student.walk();
      student.swim();
      System.out.println(student.toString());

      List<Integer> integers = new ArrayList<>(Arrays.aslist(100, 200, 300));
      student.sum(integers); //100+200+300=600

      List<Integer> integers2 = Arrays.asList(20, 30, 100);

      //student.sum(Arrays.asList(10, 30, 100)); //10+30+100=140
      System.out.println(student.sum(integers2));
      //integers2.add(2); //error, no new, no object


     //Dynamic Polymorphism
     Person person = new Student();
     Person person2 = new Student(1.0, 2.0, 3); // height/ weight/ year
    
     Person person3 = Person.getPerson(3); // get onject according to category

     long l =1;
     byte a = (byte) 128; // overflow = data lost



     //Student student2 = new Person();

     //person .calulate() // no this method in person object





    }
    
  }

