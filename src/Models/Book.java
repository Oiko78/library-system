package Models;

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
  public String title;
  public String author;
  public boolean isAvailable;

  public Book(String title, String author, boolean isAvailable) {
    this.title = title;
    this.author = author;
    this.isAvailable = isAvailable;
  }

  /**
   * Displays formatted book's attributes.
   */
  @Override
  public String toString() {
    String str = "";
    str = str.concat(title + "\n");
    str = str.concat("author: " + author + "\n");
    str = str.concat("status: " + (isAvailable ? "available" : "borrowed"));
    return str;
  }
}
