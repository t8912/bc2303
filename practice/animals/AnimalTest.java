package week4.practice.animals;

public class AnimalTest {

  public static void main(String[] args) {
    Dog dog = new Dog("Mark", 3);
    Cat cat = new Cat("Jackie", 2);

    Animal[] animals = new Animal[2];
    animals[0] = dog;
    animals[1] = cat;

    for (Animal animal : animals) {
      animal.makeSound();
      animal.eat();
      animal.sleep();

      if (animal instanceof Dog) {
        Dog d = (Dog) animal;
        d.playFetch();
      } else if (animal instanceof Cat) {
        Cat c = (Cat) animal;
        c.scratch();
      }
    }
  }

}
