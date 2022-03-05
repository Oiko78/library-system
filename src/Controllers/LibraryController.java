package Controllers;

import java.util.ArrayList;

import Helpers.Util;
import Models.Book;
import Models.Library;
import Models.User;

public class LibraryController {
  private Library library;
  public User user;

  public LibraryController(Library library) {
    this.library = library;
  }

  public boolean insertBook(String title, String author) {
    if (title.isEmpty() || author.isEmpty())
      return false;

    this.library.books.add(new Book(title, author, true));
    return true;
  }

  public ArrayList<Book> getAllBooks() {
    return this.library.books;
  }

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
