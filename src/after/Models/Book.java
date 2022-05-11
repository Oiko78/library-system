package after.Models;

/**
 * {@code Book} class represents a book that has attributes such as title,
 * author, and book avaibility.
 * 
 * <p>
 * Usage example:
 * <blockquote>
 * 
 * <pre>
 * Book book = new Book("title", "author", true);
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * @author Oliver Chico
 * @author Kevin Bryan
 */
public class Book {
  private String title;
  private String author;
  private boolean available;

  public Book(String title, String author, boolean available) {
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

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void updateBook(String title, String author) {
    this.title = title.isEmpty() ? this.title : title;
    this.author = author.isEmpty() ? this.author : author;
  }

  /**
   * Displays formatted book's attributes.
   */
  @Override
  public String toString() {
    String str = "";
    str = str.concat(title + "\n");
    str = str.concat("author: " + author + "\n");
    str = str.concat("status: " + (available ? "available" : "borrowed"));
    return str;
  }

  public boolean compareTo(String title) {
    return this.title.equals(title);
  }
}
