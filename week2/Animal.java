package week2;

public abstract class Animal {
  
 String name;
 String height;
 //String color; 

public abstract void sound()

public String sound2() {
  return "Meow Meow";
}

 public Animal(){
  
 }

public Animal(String color, String name, String height){
  
}

 public Animal(String name) {
  this.name = name;
 }

 public void setName(String name) {
  this.name = name;
 }

}
