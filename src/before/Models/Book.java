package before.Models;

import java.util.Date;

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

  // Broken Modularization
  BookData bookData;

  public Book(String title, String author, boolean available) {
    this.bookData = new BookData(title, author, available);
  }

  public void updateBook(String title, String author) {
    this.bookData.title = title.isEmpty() ? this.bookData.title : title;
    this.bookData.author = author.isEmpty() ? this.bookData.author : author;
  }

    
  public String getBookTitle() {
    return this.bookData.getBookTitle();
  }

  public String getBookAuthor() {
    return this.bookData.getBookAuthor();
  }

  public boolean isAvailable() {
    return this.bookData.available;
  }

  public void setUnavailable() {
    this.bookData.available = false;
  }

  public void setAvailable() {
    this.bookData.available = true;
  }

  /**
   * Displays formatted book's attributes.
   */
  @Override
  public String toString() {
    String str = "";
    str = str.concat(this.getBookTitle() + "\n");
    str = str.concat("author: " + this.getBookAuthor() + "\n");
    str = str.concat("status: " + (this.bookData.available ? "available" : "borrowed"));
    return str;
  }
}
