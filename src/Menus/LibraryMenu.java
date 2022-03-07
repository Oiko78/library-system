package Menus;

import Helpers.Util;
import Models.Book;
import Models.Library;
import Models.Member;
import Models.Staff;
import Models.User;


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
 * 
 * @see Models.User
 * @see Models.Library
 * @see Models.Book
 */
public class LibraryMenu {
  private Library library;
  private User user;

  public LibraryMenu(Library library, User user) {
    this.library = library;
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

  private boolean memberMainMenu() {
    int menu = -1;
    while(menu != 5){
      System.out.println("Library");
      System.out.println("===========");
      System.out.println("1. View All Books");
      System.out.println("2. View Avaialble Books");
      System.out.println("3. Borrow a Book");
      System.out.println("4. Return a Book");
      System.out.println("5. Exit");

      try {
        menu = Util.scanInteger();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }
      // Util.scan.nextLine();
  
      switch (menu) {
        case 1:
          viewAllBook(library);
          break;
        case 2:
          viewAvailableBook(library);
          break;
        case 5:
          return false;
      }
    }
    return true;
  }

  private boolean staffMainMenu() {
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Avaialble Books");
    System.out.println("3. Add a Book");
    System.out.println("4. Update a Book");
    System.out.println("5. Delete a Book");
    System.out.println("6. Exit");

    int menu = -1;
    try {
      menu = Util.scan.nextInt();
    } catch (Exception e) {
      Util.clearConsole();
      Util.showError(e);
    }
    Util.scan.nextLine();

    switch (menu) {
      case 6:
        return false;
    }
    return true;
  }

      // To view all the books in library
    public static void viewAllBook(Library library){
      System.out.println();
      for(int i = 0; i < library.books.size(); i++){
        Book currBook = library.books.get(i);
        System.out.println(currBook.toString());
      }
      System.out.println();
      Util.cont();
    }
      
        // To view all the book that are available
    public static void viewAvailableBook(Library library){
      System.out.println();
      for(int i = 0; i < library.books.size(); i++){
        Book currBook = library.books.get(i);
        if(currBook.isAvailable)
        System.out.println(currBook.toString());
      }
      System.out.println();
      Util.cont();
    }

}
