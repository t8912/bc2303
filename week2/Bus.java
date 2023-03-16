package week2;

import java.util.ArrayList;

public class Bus {
  static int peopleAtDestination; // total number of people at destination

  Driver driver;  // Driver Class
  int totalNoOfSeat;
  String PlatNo;

  ArrayList<String> passengers = new ArrayList<>(); // one to many 

  public void addPeople(String passengerNAme) {
    this.passengers.add(passengerNAme);
  }

  public void releasePeople() {
    peopleAtDestination = peopleAtDestination + this.passengers.size();
    this.passengers.clear();
  }

  public static void main(String[] args) {
    Bus bus;
    for (int i = 0; i < 5; i++) {
      bus = new Bus(); // Bus
      bus.driver = new Driver("   Kelvin");

      if (i == 0) {
        bus.addPeople("Jason");
        bus.addPeople("Error");
      } else if (i == 2) {
        bus.addPeople("Mary");
      }
      bus.releasePeople();
    System.out.println("total number of people at destination=" + peopleAtDestination); // print 2
  }

}
}

