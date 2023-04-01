package week3.classes;

public enum Compass { // implicity final



/**
 *  
 * 
 * 
 * 
 * 
 */


  NORTH(1, "North"), // (Static final)
  SOUTH(-1, "South"), // (Static final)
  WEST(2, "West"), // 2 * -1 = -2 (Static final)
  EAST(-2, "East"); // -2 * -1 = 2 (Static final)

private int code;
private String desc;

private Compass(int code, String desc) {
  this.code = code;
  this.desc = desc;
}

public int getCode() {
  return this.code;
}

public String getDesc(){
  return this.desc;
}

public boolean isOpposite(Compass compass){
   return this.code * -1 == compass.getCode();
  //if (this.code * -1 == compass.getCode()) {
  }

private static Compass valuesOf(String s) { //"WEST"
// input param s, check if it is an unexpected value, i.e. null
if (s == null) 
   return null;

   for (Compass compass : Compass.values()){ //enum.values()
       if (compass.name().equals(s.trim())) {
        return compass;
       }
      }
      return null;
   }



  public static void main(String[] args) {
    if (Compass.NORTH.isOpposite(Compass.SOUTH)){ // if EAST, cannot be print out
      System.out.println("This is opposite");
    }
    System.out.println(Compass.WEST.name()); // return String, Print WEST
    System.out.println(Compass.valueOf("WEST"));
    if (Compass.WEST == Compass.valuesOf("WEST")) { // if "WES T", will error
      System.out.println(Compass.WEST.name());
    }
  }


  }







  ///private int degrees; //defined a private integer value `degrees` for each direction

 //private constructor that takes an integer parameter 
 //and sets the `degrees` value for each constant
 /// private Compass(int degrees){
    ///this.degrees = degrees;
  ///}

  //defined a public `getDegrees()` method that returns the `degrees` value for each direction
  ///public int getDegrees() {
    ///return degrees;
 /// }

///}

//declared a variable `direction` of the `Compass`

//Compass direction = Compass.NORTH;
//int degrees = direction.getDegrees(); // returns 0
