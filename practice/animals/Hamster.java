package week4.practice.animals;

public class Hamster implements Pet {
    private String name;
    private int age;

    public Hamster(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void play() {
        System.out.println(name + " is running on its wheel.");
    }
}
