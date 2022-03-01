package Views;

import java.util.ArrayList;

import Controller.LibraryController;
import Models.Book;
import Utils.Util;

public class LibraryView {
  LibraryController libraryController;

  public LibraryView(LibraryController libraryController) {
    this.libraryController = libraryController;
  }

  public void InsertMenu(boolean inMenu) {
    String title = "";
    String author = "";

    while (inMenu) {
      Util.clearConsole();

      System.out.println("Insert book data!");
      System.out.println("=======================");
      try {
        System.out.print("Book title: " + (title.isEmpty() ? "" : title + "\n"));
        if (title.isEmpty())
          title = libraryController.getBookTitle();

        System.out.print("Book author: " + (author.isEmpty() ? "" : author + "\n"));
        if (author.isEmpty())
          author = libraryController.getBookAuthor();

      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
        continue;
      }

      inMenu = false;
    }

    Util.clearConsole();
    System.out.printf("%s book successfully inserted.\n", title);
    libraryController.insertBook(new Book(title, author));
    Util.cont();
    return;
  }

  public void GetAllBookMenu(boolean inMenu) {
    Util.clearConsole();

    ArrayList<Book> books = libraryController.getAllBooks();
    if (books.size() == 0) {
      System.out.println("Library currently has no book to read!\nPlease come backlater.");
      Util.cont();
      return;
    }

    System.out.println("Showing book list");
    System.out.println("=========================================================");
    System.out.printf("| %-25s | %-25s |\n", "Title", "Author");
    System.out.println("=========================================================");

    for (Book book : books)
      System.out.printf("| %-25s | %-25s |\n", book.title, book.author);

    System.out.println("=========================================================\n");
    Util.cont();
  }
}
