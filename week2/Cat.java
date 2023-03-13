package week2;

public  class Cat extends Animal {
  // inherit Animal.name
  String color;

  public Cat() {
   //super(); <---Empty contructor
  }

  //Contructor & Super
  public Cat(String color, String name) {
    super(name);
    this.color = color;
  }

  public void setColor(String color){
    this.color = color;
  }

  public static void main(String[] args) {
    Cat cat = new Cat();
    cat.setName("Kathy");
    cat.setColor("Yellow");

    Cat cat2 = new Cat("Yellow", "Sally");


    
  }
}
