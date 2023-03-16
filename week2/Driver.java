package week2;

public class Driver {
  String name;

  public Driver(){

  }

  public Driver(String name) {
    if (name == null || "".equals(name)) {
      this.name = "N/A";
    } else {
      this.name = name.trim();
    }
    
  }
  
}

