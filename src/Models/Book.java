package Models;

public class Book {
  public String title;
  public String author;
  boolean available;

  public Book(String title, String author, boolean available) {
    this.title = title;
    this.author = author;
    this.available = available;
  }
}
