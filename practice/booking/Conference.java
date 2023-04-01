package week4.practice.booking;

public class Conference extends Event {

  private String location;

  public Conference(String name, String date, int numberOfAttendees, String location) {
    super(name, date, numberOfAttendees);
    this.location = location;
  }

  public String getLocation(){
    return location;
  }

  public void setLocation(){
    this.location = location;
  }

  //////
  public void displayDetails(){
    System.out.println("Conference: " + getName());
    System.out.println("Date: " + getDate());
    System.out.println("Location: " + location);
    System.out.println("Number of attendees: " + getNumberOfAttendees());
  }
}
