package before.Models;

public class BookData {
  protected String title;
  protected String author;
  protected boolean available;

  public BookData(String title, String author, boolean available) {
    this.title = title;
    this.author = author;
    this.available = available;
  }
  
  public String getBookTitle() {
    return this.title;
  }

  public String getBookAuthor() {
    return this.author;
  }

  public boolean isAvailable() {
    return this.available;
  }

  public void setUnavailable() {
    this.available = false;
  }

  public void setAvailable() {
    this.available = true;
  }
}
