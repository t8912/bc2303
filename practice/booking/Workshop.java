package week4.practice.booking;

public class Workshop extends Event{

  private String presenter;

  public Workshop(String name, String date, int numberOfAttendees, String presenter){
    super(name, date, numberOfAttendees);
    this.presenter = presenter;
  }

  public String getPresenter(){
    return presenter;
  }

  public void setPresenter(String presenter){
    this.presenter = presenter;
  }


  //////
  public void displayDetails(){
    System.out.println("Workshop: " + getName());
    System.out.println("Date: " + getDate() );
    System.out.println("Presenter:" + presenter);
    System.out.println("Number of attendees: " + getNumberOfAttendees());
  }

}
