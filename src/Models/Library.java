package Models;

import java.util.ArrayList;

/**
 * This {@code Library} class holds any information about a library such as
 * list of available books. By default, this class will make its own default but
 * this books can be initialized by calling the constructor.
 *
 * @author Oliver Chico
 * @see Models.Book
 */
public class Library {
  public ArrayList<Book> books;

  /**
   * Initialize {@code Library} object that contains a list of predefined books;
   *
   */
  public Library() {
    this.books = new ArrayList<>();
    books.add(new Book("This is title", "This is author", true));
  }

  /**
   * Initialize {@code Library} object that contains a list of user-defined books;
   *
   * @param books list of {@code Book}
   */
  public Library(ArrayList<Book> books) {
    this.books = books;
  }
}
