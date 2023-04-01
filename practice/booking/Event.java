package week4.practice.booking;

public abstract class Event implements Bookable {

  private String name;
  private String date;
  private int numberOfAttendees;

 public Event(String name, String date, int numberOfAttendees){
  this.name = name;
  this.date = date;
  this.numberOfAttendees = numberOfAttendees;
 }

 public String getName(){
  return name;
 }

 public String getDate(){
  return date;
 }
  
 public int getNumberOfAttendees(){
  return numberOfAttendees;
 }

public void setName(String name){
  this.name = name;
}

public void setDate(String date){
  this.date = date;
}

public void setNumberOfAttendees(int numberOfAttendees){
  this.numberOfAttendees = numberOfAttendees;
}

public abstract void displayDetails();

public void book(){
  System.out.println("Booking event: " + name + " on " + date + " for " + numberOfAttendees + " attendees.");
}

public void cancelBooking(){
System.out.println("Canncelling booking for event: " + name + " on " + date + " .");
}

}


