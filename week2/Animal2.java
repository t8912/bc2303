package week2;

public class Animal2 {
  public void makeSound() {
    System.out.println("Generic animal sound.");
  }
}

public class Dog extends Animal2 {
  @Override
  public void makeSound() {
    System.out.println("Bark!");
  }
}

public class Cat extends Animal2 {
  @Override
  public void makeSound() {
    System.out.println("Meow!");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();
    myAnimal.makeSound(); // Output: "Generic animal sound."

    Dog myDog = new Dog();
    myDog.makeSound(); // Output: "Bark!"

    Cat myCat = new Cat();
    myCat.makeSound(); // Output: "Meow!"
  }
}
