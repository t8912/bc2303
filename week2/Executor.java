package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.events.StartDocument;

public class Executor {
  public static void main(String[] args) {
    Student s = new Student(); // instance or object
    s.setFirstName("John");

    Student s2 = new Student(); // instance or object
    s2.setFirstName("Mary");

    System.out.println(s.getFirstName());
    System.out.println(s2.getFirstName());

    s.setFirstName("Peter");

    School school = new School();
    List<Student> students = new ArrayList<>();
    students.add(s);
    students.add(s2);
    school.setStudents(students);

    // Exam
    Exam exam = new Exam();
    exam.setScore(60);

    if (exam.getScore() > 60) { // requirement
      System.out.println("Exam is passed");
    }

    if (exam.isPassed()) { // requirement
      System.out.println("Exam is passed");
    }

    /////////////////////////////////////////////  
    Room room1 = new Room();
    room1.setRoom1("Class 1A");

    Room room2 = new Room();
    room2.setRoom2("Class 1B");

    Room room3 = new Room();
    room3.setRoom3("Class 1C");

    Room room4 = new Room();
    room4.setRoom4("Class 1D");

    Room room5 = new Room();
    room5.setRoom5("Class 1E");

    System.out.println(room1.getRoom1());
    System.out.println(room2.getRoom2());
    System.out.println(room3.getRoom3());
    System.out.println(room4.getRoom4());
    System.out.println(room5.getRoom5());


  //Contructor
   Library book1 = new Library("Book", "fiction", "Peter", "1996");
   book1.setBooktName("Book123456");
   book1.setBookType("Computing");
   book1.setAuthor("Tom");
   book1.setYearofPublication("1999");

   System.out.println(book1.getBooktName());
   System.out.println(book1.getBookType());
   System.out.println(book1.getAuthor());
   System.out.println(book1.getsetYearofPublication());
   
  
   Library book2 = new Library();
   //book2.setBooktName("Book1");


  }
}