package week4.practice.booking;

import java.util.ArrayList;

public class BookingSystem {

  private ArrayList<Event> events;

  public BookingSystem() {
    events = new ArrayList<Event>();
  }

  public void addEvent(Event event) {
    events.add(event);
  }

  public void removeEvent(Event event) {
    events.remove(event);
  }

  public void bookEvent(EventType eventType, String name, String date, int numberOfAttendees,
      String locationOrPresenter) {
    switch (eventType) {

      case CONFERENCE:
        Conference conference = new Conference(name, date, numberOfAttendees, locationOrPresenter);
        conference.book();
        addEvent(conference);
        break;

      case WORKSHOP:
        Workshop workshop = new Workshop(name, date, numberOfAttendees, locationOrPresenter);
        workshop.book();
        addEvent(workshop);
        break;

      default:
        System.out.println("Invalid event type. ");
        break;
    }
  }

  public void cancelBooking(Event event) {
    event.cancelBooking();
    removeEvent(event);
  }

  public void displayEvents() {
    for (Event event : events) {
      event.displayDetails();
      System.out.println("--------------------");
    }
  }

  public static void main(String[] args) {

    BookingSystem bookingSystem = new BookingSystem();

    bookingSystem.bookEvent(EventType.CONFERENCE, "IT Conference", "2023-03-01", 100, "HK");
    bookingSystem.bookEvent(EventType.WORKSHOP, "IT Workshop", "2023-04-01", 200, "Tommy");
    bookingSystem.bookEvent(EventType.WORKSHOP, "IT2 Workshop", "2023-05-01", 300, "Peter");

    System.out.println("***************************");

    bookingSystem.displayEvents();

    System.out.println("===========================");

    Event event = bookingSystem.events.get(1);
    bookingSystem.cancelBooking(event);

    System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>");

    bookingSystem.displayEvents();

  }

}
