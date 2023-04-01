package week4.practice.animals;

public class Dog extends Animal {

  public Dog(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + " says woof!");
  }

  public void playFetch() {
    System.out.println(getName() + " is playing fetch.");
  }

}
