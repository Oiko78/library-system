package before.Models;

import java.util.ArrayList;
import java.util.Scanner;

import before.Helpers.Util;

/**
 * {@code Library} class represents a library that has a list of books that can
 * be initialized manually.
 * 
 * <p>
 * Usage example:
 * <blockquote>
 * 
 * <pre>
 * ArrayList<Book> books = new ArrrayList<>();
 * books.add(new Book("title1", "author1", true));
 * books.add(new Book("title2", "author2", true));
 * 
 * Library = new Library(books);
 * </pre>
 * 
 * </blockquote>
 * </p>
 * <p>
 * By default, library consists pre-initialized books. Example:
 * <blockquote>
 * 
 * <pre>
 * Library library = Library.initializeLibrary();
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * @author Oliver Chico
 * @author Kevin Bryan
 * 
 * @see Models.Book
 */
public class Library {
  private ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<Book>();
  }

  public Library(ArrayList<Book> books) {
    this.books = books;
  }

  public ArrayList<Book> getBooks() {
    return new ArrayList<Book>(books);
  }

  public Book getBook(int index) {
    return books.get(index);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void insertBook(Book book) {
    books.add(book);
  }

  /**
   * Initialize a library that consist of a list of books for development purpose.
   * 
   * @return {@code ArrrayList<Book>}
   */
  public static Library initializeLibrary() {
    ArrayList<Book> books = new ArrayList<>();
    books.add(new Book("Coding", "Steve Jobs", true));
    books.add(new Book("Programming", "Stevie Wonder", true));
    books.add(new Book("Naruto", "Sasuke Uchiha", false));
    books.add(new Book("Tokyo Ghoul", "Kaneki", true));

    return new Library(books);
  }

  public boolean isExistsBook(String title) {
    for (Book book : books)
      if (book.getBookTitle().compareTo(title) == 0)
        return true;

    return false;
  }

  public static Book searchTitle(ArrayList<Book> books, String title) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getBookTitle().equals(title))
        return books.get(i);
    }
    return null;
  }

}
