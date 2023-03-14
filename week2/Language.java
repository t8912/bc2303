package week2;

public abstract class Language {

//public abstract class Language {
   //Attribute 
     String name;
     String creator;
 
   //Constructor  
    public Language(String name, String creator) {
       this.name = name;
       this.creator = creator;
    }
 
    public String getName() {
       return name;
    }
 
    public String getCreator() {
       return creator;
    }

    public abstract void sayHi();
 
   
 }
 
 class Java extends Language {
    public Java() {
       super("Java", "Peter");
    }
 
   /// @Override
    ///public void sound() {
     //System.out.println("Meow Meow Mwow");
    ///}


     //public abstract void sayHi();
     public void sayHi() {
       System.out.println("Hi, Java!");
    }
  
    public static void main(String[] args) {
       Language java = new Java();
       System.out.println(java.getName() + " was created by " + java.getCreator());
       //java.sayHi();
 
    
    }
 }

