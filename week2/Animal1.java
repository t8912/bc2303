package week2;

public class Animal1 {

  
  public void makeSound() {
    System.out.println("Generic animal sound.");
  }

public class Dog extends Animal1 {
  @Override
  public void makeSound() {
    System.out.println("Bark!");
  }
}

public class Cat extends Animal1 {
  @Override
  public void makeSound() {
    System.out.println("Meow!");
  }
}


public class Main {
  public static void main(String[] args) {
    Animal1 myAnimal1 = new Animal1();
    myAnimal1.makeSound(); // Output: "Generic animal sound."
    
    Dog myDog = new Dog();
    myDog.makeSound(); // Output: "Bark!"

    Cat myCat = new Cat();
    myCat.makeSound(); // Output: "Meow!"
  }
}

}

