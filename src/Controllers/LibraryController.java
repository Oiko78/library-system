package Controllers;

import java.util.ArrayList;

import Models.Book;
import Models.Library;
import Utils.Util;

public class LibraryController {
  private Library library;

  public LibraryController(Library library) {
    this.library = library;
  }

  public void insertBook(Book book) {
    this.library.books.add(book);
  }

  public ArrayList<Book> getAllBooks() {
    return this.library.books;
  }

  public String getBookTitle() throws Exception {
    try {
      String title = Util.scan.nextLine();
      if (title.isEmpty())
        throw new Exception("Title must not empty!");

      return title;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  public String getBookAuthor() throws Exception {
    try {
      String author = Util.scan.nextLine();
      if (author.isEmpty())
        throw new Exception("Author must not empty!");

      return author;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

}
