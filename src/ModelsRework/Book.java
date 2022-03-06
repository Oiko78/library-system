package ModelsRework;

public class Book {
  String id;
  String title;
  String author;
  boolean available;
  
  public Book(String id, String title, String author, boolean available) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.available = available;
  }
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public boolean isAvailable() {
    return available;
  }
  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void printBook(){
    System.out.println(this.title + "\t" + this.id );
    System.out.println("written by: "+this.author);
    System.out.println("status: " + (this.available? "available": "borrowed"));
  }
}
