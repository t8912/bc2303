package week4.practice.booking;

public class MainMethods {

  public static void main(String[] args) {
  
  BookingSystem bookingSystem = new BookingSystem();

  bookingSystem.bookEvent(EventType.CONFERENCE, "IT Conference", "2023-03-31", 100, "HK");
  bookingSystem.bookEvent(EventType.WORKSHOP, "IT Workshop", "2023-04-01", 200, "Tommy");

  System.out.println("***************************");
  bookingSystem.displayEvents();


  Event event = new 
  
  
  bookingSystem.events.get(0);
  //Event event = bookingSystem.
  //bookingSystem.cancelBooking(event);

  //bookingSystem.displayEvents();

  }
}
