package week2;

public class Library {

  private String bookName;
  private String bookType;
  private String author;
  private String yearOfPublication;


  public Library() {
    
  }

  public Library(String bookName, String bookType, String author, String yearOfPublication) {
      this.bookName = bookName;
      this.bookType = bookType;
      this.author = author;
      this.yearOfPublication = yearOfPublication;
      
      
    //super(bookName, bookType, author, yearOfPuplication);
   // this.bookName = bookName;

   //public static void main(String[] args){
    //fireFigther f1 = new Firefighter("John", 23, 170, 200);
  // }

  

  }
  

  public void setBooktName(String bookName) {
    this.bookName = bookName;
  }

  public String getBooktName() {
    return this.bookName;
  }

  public void setBookType(String bookType) {
    this.bookType = bookType;
  }

  public String getBookType() {
    return this.bookType;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setYearofPublication(String yearOfPublication) {
    this.yearOfPublication = yearOfPublication;
  }

  public String getsetYearofPublication() {
    return this.yearOfPublication;
  }

  

  }

  

