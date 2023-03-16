package week2;

public  class Cat extends Animal {
  // inherit Animal.name
  String color;
  String name;
  String height;

  public Cat() {
   //super(); <---Empty contructor
  }

  //Contructor & Super
  public Cat(String color, String name, String height) {
    super(color, name, height);
    this.color = color;
  }

  public void setColor(String color){
    this.color = color;
  }

   //
   @Override // documentation
   public String toString(){
    return "[" + this.color + " "+ super.name//
    + " " + super.height + "]";
   }

   @Override
   public void sound() {
    System.out.println("Meow Meow Mwow");
   }

   public void sound(int x) {  // method overloading sound() , sound (int x)
   System.out.println(x);
   }

   public void sound(String x) {  // method overloading 
    System.out.println(x);
    }

    public void sound(Boolean x) {  // method overloading 
      System.out.println(x);
      }

   
   //int num1 = 7;
   //int num2 = 3;
   //int result = 7 / 3;

   //System.out.println("The result is " + result);


    public double calculateReminder(int a, int b) {
     //return (double) a / (double) b;
     return a % b;
    }

    public static int sum(int[] nums) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
    
      }
      return sum;
    }
    
    public static int sum1(int... nums) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
    
      }
      return sum;
    }





 

  public static void main(String[] args) {
    Cat cat = new Cat();
    cat.setName("Kathy");
    cat.setColor("Yellow");

    Cat cat2 = new Cat("Yellow", "Sally", "0.3");
    System.out.println(cat.toString());
     cat2.sound(3);
     cat2.sound("hello");
     cat2.sound(false);


     String str = String.valueOf(3.2);
     String str2 = String.valueOf(3);
     String str3 = String.valueOf(true);
    
      System.out.println(cat.calculateReminder(32, 3));
      System.out.println(cat.sum(1, 2, 3, 4, 5));
      System.out.println(cat.sum(1, 2, 3));


      AmountHolder holder = new AmountHolder(10);
      doSomething(holder);
      System.out.println("Amount is " + holder.getAmount());
          
        }
      
      }
      

 // }
//}

//public class PassReferenceByValue {
  //public static void doSomething(AmountHolder holder){
    //holder = new AmountHolder(99);
    
  //}

//}
