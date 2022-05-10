package before.Menus;

import java.util.ArrayList;

import before.Models.Book;
import before.Models.Library;
import before.Models.Member;
import before.Models.Staff;
import before.Models.User;
import before.Helpers.Util;

/**
 * {@code LibraryMenu} class represents a menu that will displays some action
 * related to library
 * that can be choose by either {@code Member} or {@code Staff}. Menu shown may
 * differ depends
 * on current user.
 * 
 * <p>
 * Usage example:
 * <blockquote>
 * 
 * <pre>
 * Library library = new Library();
 * User user = new Staff("admmin", "admin", "admin", 20);
 * 
 * LibraryMenu libraryMenu = new LibraryMenu(library, user);
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * 
 * @author Oliver Chico
 * @author Kevin Bryan
 * @author Nicholas Indra Wijaa
 * 
 * @see Models.User
 * @see Models.Library
 * @see Models.Book
 */
public class LibraryMenu {
  private Library library;
  private User user;
  private ArrayList<Book> books;

  public LibraryMenu(Library library, User user) {
    this.library = library;
    this.user = user;
    this.books = library.getBooks();
  }

  public User displayMainMenu() {
    boolean inMenu = true;
    while (inMenu) {
      Util.clearConsole();

      if (user instanceof Member)
        inMenu = memberMainMenu();

      if (user instanceof Staff)
        inMenu = staffMainMenu();

      if (inMenu)
        Util.scan.nextLine();
    }

    return null;
  }

  // [Long Method]
  private boolean memberMainMenu() {
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Available Books");
    System.out.println("3. Borrow a Book");
    System.out.println("4. Return a Book");
    System.out.println("5. Exit");

    int menu = -1;
    try {
      menu = Util.scanInteger();
    } catch (Exception e) {
      Util.clearConsole();
      Util.showError(e);
    }

    if (menu == 1) { // viewAllBooks
      Util.clearConsole();

      System.out.println("=======================");
      for (int i = 0; i < books.size(); i++) {
        System.out.println((i + 1) + ". " + books.get(i));
        if (i == books.size() - 1)
          continue;

        System.out.println("-----------------------");
      }
      System.out.println("=======================\n");
    } else if (menu == 2) { // viewAvailableBooks
      Util.clearConsole();

      ArrayList<Book> availableBooks = new ArrayList<>(books);
      availableBooks.removeIf(book -> !book.isAvailable());
      if (availableBooks.size() == 0) {
        System.out.println("No Books are currently available...");
      } else {
        System.out.println("=======================");
        for (int i = 0; i < availableBooks.size(); i++) {
          System.out.println((i + 1) + ". " + availableBooks.get(i));
          if (i == availableBooks.size() - 1)
            continue;

          System.out.println("-----------------------");
        }
        System.out.println("=======================\n");
      }
    } else if (menu == 3) { // borrowBook
      ArrayList<Book> availableBooks = new ArrayList<>(books);
      availableBooks.removeIf(book -> !book.isAvailable());
      if (availableBooks.size() == 0) {
        System.out.println("No Books are currently available...");
      } else {
        System.out.println("=======================");
        for (int i = 0; i < availableBooks.size(); i++) {
          System.out.println((i + 1) + ". " + availableBooks.get(i));
          if (i == availableBooks.size() - 1)
            continue;

          System.out.println("-----------------------");
        }
        System.out.println("=======================\n");
        System.out.println("What book to borrow?");
        int index = -1;
        while (!(index >= 1 && index <= books.size())) {
          System.out.println("Input the Book Number:");
          index = Util.scanInteger();
        }
        Book borrowedBook = availableBooks.get(index - 1);
        ((Member) user).borrowBook(borrowedBook);
        System.out.println("You have succesfully borrowed " + borrowedBook.getBookTitle());
      }
    } else if (menu == 4) { // returnBook
      String title = "";
      while (title.isEmpty()) {
        System.out.println("Book Title: ");
        title = Util.scanLine();
      }
      Book returnedBook = Library.searchTitle(books, title);
      if (returnedBook == null) {
        System.out.println("Not a book from this library...");
      } else {
        ((Member) user).returnBook(returnedBook);
        System.out.println("Thanks for returning " + returnedBook.getBookTitle());
      }
    } else if (menu == 5) {
      return false;
    }
    return true;
  }


  private boolean staffMainMenu() {
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Available Books");
    System.out.println("3. Add a Book");
    System.out.println("4. Update a Book");
    System.out.println("5. Delete a Book");
    System.out.println("6. Exit");

    int menu = -1;
    try {
      menu = Util.scanInteger();
    } catch (Exception e) {
      Util.clearConsole();
      Util.showError(e);
    }

    if (menu == 1) { // viewAllBooks
      System.out.println("=======================");
      for (int i = 0; i < books.size(); i++) {
        System.out.println((i + 1) + ". " + books.get(i));
        if (i == books.size() - 1)
          continue;

        System.out.println("-----------------------");
      }
      System.out.println("=======================\n");
    } else if (menu == 2) { // viewAvailableBooks
      ArrayList<Book> availableBooks = new ArrayList<>(books);
      availableBooks.removeIf(book -> !book.isAvailable());
      if (availableBooks.size() == 0) {
        System.out.println("No Books are currently available...");
      } else {
        System.out.println("=======================");
        for (int i = 0; i < availableBooks.size(); i++) {
          System.out.println((i + 1) + ". " + availableBooks.get(i));
          if (i == availableBooks.size() - 1)
            continue;

          System.out.println("-----------------------");
        }
        System.out.println("=======================\n");
      }
    } else if (menu == 3) { // insertBook
      String title = "";
      String author = "";

      while (title.isEmpty()) {
        System.out.println("Book Title: ");
        title = Util.scanLine();
      }

      while (author.isEmpty()) {
        System.out.println("Book Author: ");
        author = Util.scanLine();
      }

      books.add(new Book(title, author, true));
      System.out.println("Book successfully added to library!");
    } else if (menu == 4) { // updateBook
      System.out.println("=======================");
      for (int i = 0; i < books.size(); i++) {
        System.out.println((i + 1) + ". " + books.get(i));
        if (i == books.size() - 1)
          continue;

        System.out.println("-----------------------");
      }
      System.out.println("=======================\n");

      int index = -1;
      while (!(index >= 1 && index <= books.size())) {
        System.out.println("Input the Book Number:");
        index = Util.scanInteger();
      }

      Book currBook = books.get(index - 1);

      String title = "";
      String author = "";

      while (title.isEmpty()) {
        System.out.println("Book Title: ");
        title = Util.scanLine();
      }

      while (author.isEmpty()) {
        System.out.println("Book Author: ");
        author = Util.scanLine();
      }

      currBook.updateBook(title, author);
      System.out.println("Book successfully updated!");
    } else if (menu == 5) { // deleteBook
      System.out.println("=======================");
      for (int i = 0; i < books.size(); i++) {
        System.out.println((i + 1) + ". " + books.get(i));
        if (i == books.size() - 1)
          continue;

        System.out.println("-----------------------");
      }
      System.out.println("=======================\n");

      int index = -1;
      while (!(index >= 1 && index <= books.size())) {
        System.out.println("Input the Book Number:");
        index = Util.scanInteger();
      }
      //[Dead Code]
      Book currBook = books.get(index - 1);
      books.remove(index);
      System.out.println("Book successfully removed!");
    } else if (menu == 6) {
      return false;
    }

    return true;
  }
}
