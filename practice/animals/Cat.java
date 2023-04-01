package week4.practice.animals;

public class Cat extends Animal {

  public Cat(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + " says meow!");
  }

  public void scratch() {
    System.out.println(getName() + " is scratching.");
  }

}
