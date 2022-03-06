package Controllers;

import java.util.ArrayList;

import Helpers.Util;
import Models.Book;
import Models.Library;
import Models.User;

/**
 * This class controls and manages the flow of a library including books that
 * are in library and user that logged on into library.
 *
 * @author Oliver Chico
 * @see Models.Library
 * @see Models.User
 */
public class LibraryController {
  private Library library;
  public User user;

  /**
   * Initialize a {@code Controller} object for a {@code Library}
   * 
   * @param library a {@code Library}
   */
  public LibraryController(Library library) {
    this.library = library;
  }

  /**
   * Tries to insert a book into current library while also considering title and
   * author validity. Note that this method does not checks for existing book that
   * has same title and author.
   * 
   * @param title  a {@code String}
   * @param author a {@code String}
   * @return a true {@code boolean} if book is successfully inserted otherwise
   *         false
   */
  public boolean insertBook(String title, String author) {
    if (title.isEmpty() || author.isEmpty())
      return false;

    this.library.books.add(new Book(title, author, true));
    return true;
  }

  /**
   * Get all books that are stored into current library while not considering its
   * avaibility.
   * 
   * @return a {@code List} of {@code Book}
   */
  public ArrayList<Book> getAllBooks() {
    return this.library.books;
  }

  /**
   * Tries to get a user input for book title while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public String getBookTitle() throws Exception {
    try {
      String title = Util.scan.nextLine();
      if (title.isEmpty())
        throw new Exception("Title must not empty!");

      if (title.compareToIgnoreCase("quit") == 0)
        return "quit";

      return title;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  /**
   * Tries to get a user input for book author while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public String getBookAuthor() throws Exception {
    try {
      String author = Util.scan.nextLine();
      if (author.isEmpty())
        throw new Exception("Title must not empty!");

      if (author.compareToIgnoreCase("quit") == 0)
        return "quit";

      return author;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

}
