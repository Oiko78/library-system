package after.Menus;

import java.util.ArrayList;

import after.Models.Book;
import after.Models.Library;
import after.Models.Member;
import after.Models.Staff;
import after.Models.User;
import after.Helpers.Util;

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
 * @author Nicholas Indra Wijaya
 * 
 * @see Models.User
 * @see Models.Library
 * @see Models.Book
 */
public class LibraryMenu {
  private Library library;
  private User user;

  public LibraryMenu(Library library) {
    this.library = library;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User displayMainMenu() {
    boolean inMenu = true;
    while (inMenu) {
      Util.clearConsole();

      if (user instanceof Member)
        inMenu = memberMainMenu();

      if (user instanceof Staff)
        inMenu = staffMainMenu();
    }

    return null;
  }

  //

  // // Before [Long Method]
  // private boolean memberMainMenubefore(){
  // System.out.println("Library");
  // System.out.println("===========");
  // System.out.println("1. View All Books");
  // System.out.println("2. View Available Books");
  // System.out.println("3. Borrow a Book");
  // System.out.println("4. Return a Book");
  // System.out.println("5. Exit");

  // int menu = -1;

  // try {
  // menu = Util.scanInteger();
  // } catch (Exception e) {
  // Util.clearConsole();
  // Util.showError(e);
  // }

  // switch (menu) {
  // case 1:
  // viewAllBook();
  // Util.cont();
  // break;
  // case 2:
  // viewAvailableBook();
  // Util.cont();
  // break;
  // case 3:
  // ArrayList<Book> availableBooks = getAvailableBook();
  // if (availableBooks.size() == 0) {
  // System.out.println("No Books are currently available...");
  // }else{
  // viewAvailableBook();
  // System.out.println("What book to borrow?");
  // int index = getBookIndex(availableBooks);
  // Book borrowedBook = availableBooks.get(index);
  // borrowedBook.changeStatus();
  // System.out.println("You have succesfully borrowed " +
  // borrowedBook.getBookTitle());
  // }
  // Util.cont();
  // break;
  // case 4:
  // String title = inputBookTitle();
  // Book returnedBook = Library.searchTitle(books, title);
  // if (returnedBook == null) {
  // System.out.println("Not a book from this library...");
  // }else{
  // returnedBook.changeStatus();
  // System.out.println("Thanks for returning " + returnedBook.getBookTitle());
  // }
  // Util.cont();
  // break;
  // case 5:
  // return false;
  // }
  // return true;
  // }

  // After [Long Method]
  private boolean memberMainMenu() {
    printMemberMainMenu();
    int menu = -1;
    try {
      menu = Util.scanInteger();
    } catch (Exception e) {
      Util.clearConsole();
      Util.showError(e);
    }
    switch (menu) {
      case 1:
        viewAllBook();
        Util.cont();
        break;
      case 2:
        viewAvailableBook();
        Util.cont();
        break;
      case 3:
        borrowBook();
        Util.cont();
        break;
      case 4:
        returnBook();
        Util.cont();
        break;
      case 5:
        return false;
    }
    return true;
  }

  private boolean staffMainMenu() {
    printStaffMainMenu();
    int menu = -1;
    try {
      menu = Util.scanInteger();
    } catch (Exception e) {
      Util.clearConsole();
      Util.showError(e);
    }
    switch (menu) {
      case 1:
        viewAllBook();
        Util.cont();
        break;
      case 2:
        viewAvailableBook();
        Util.cont();
        break;
      case 3:
        insertBook();
        Util.cont();
        break;
      case 4:
        updateBook();
        Util.cont();
        break;
      case 5:
        deleteBook();
        Util.cont();
        break;
      case 6:
        return false;
    }
    return true;
  }

  private void printMemberMainMenu() {
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Available Books");
    System.out.println("3. Borrow a Book");
    System.out.println("4. Return a Book");
    System.out.println("5. Exit");
  }

  private void printStaffMainMenu() {
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Available Books");
    System.out.println("3. Add a Book");
    System.out.println("4. Update a Book");
    System.out.println("5. Delete a Book");
    System.out.println("6. Exit");
  }

  /////////////////////////// User Functions////////////////////////////

  private boolean viewAllBook() {
    return library.viewBooks(false);
  }

  private boolean viewAvailableBook() {
    return library.viewBooks(true);
  }

  /////////////////////////// Member Functions////////////////////////////
  private void borrowBook() {
    if (!viewAvailableBook())
      return;

    System.out.println("What book to borrow?");
    int index = library.chooseBook();
    Book book = library.getBook(index);
    library.addTransaction(((Member) user).borrowBook(book));
    System.out.println("You have succesfully borrwed " + book.getBookTitle());
  }

  private void returnBook() {
    if (!((Member) user).viewBooks())
      return;

    String title = inputBookTitle();
    Book book = ((Member) user).getBook(title);
    if (book == null) {
      System.out.println("You did not borrow that book.");
      return;
    }
    library.removeTransaction(((Member) user).returnBook(book));
    System.out.println("Thanks for returning " + book.getBookTitle());
  }

  /////////////////////////// Admin Functions////////////////////////////

  private void insertBook() {
    String title = inputBookTitle();
    String author = inputBookAuthor();
    library.insertBook(new Book(title, author, true));
    System.out.println("Book successfully added to library!");
  }

  public void updateBook() {
    if (!viewAllBook())
      return;

    int index = library.chooseBook();
    Book book = library.getBook(index);
    String title = inputBookTitle();
    String author = inputBookAuthor();
    book.updateBook(title, author);
    System.out.println("Book successfully updated!");
  }

  private void deleteBook() {
    if (!viewAllBook())
      return;

    int index = library.chooseBook();
    library.removeBook(index);
    System.out.println("Book successfully removed!");
  }

  ///////////////////// Function for getting input +
  ///////////////////// validation/////////////////////

  private String inputBookTitle() {
    String title = "";
    while (title.isEmpty()) {
      System.out.println("Book Title: ");
      title = Util.scanLine();
    }
    return title;
  }

  private String inputBookAuthor() {
    String author = "";
    while (author.isEmpty()) {
      System.out.println("Book Author: ");
      author = Util.scanLine();
    }
    return author;
  }
}
