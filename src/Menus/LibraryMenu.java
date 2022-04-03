package Menus;

import java.util.ArrayList;

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
  private ArrayList<Book> books;

  public LibraryMenu(Library library, User user) {
    this.library = library;
    this.user = user;
    this.books = library.getBooks();
  }

  // private ArrayList<Book> getAllBooks(){
  //   return library.getBooks();
  // }

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
    System.out.println("Library");
    System.out.println("===========");
    System.out.println("1. View All Books");
    System.out.println("2. View Avaialble Books");
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

    switch (menu) {
      case 1:
        viewAllBook();
        Util.cont();
        break;
      case 2:
        viewAvailableBook();
        Util.cont();
        break;
      case 5:
        return false;
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
        break;
      case 4:
        updateBook();
        break;
      case 5:
        deleteBook();
        break;
      case 6:
        return false;
    }
    return true;
  }

  // To view all the books in library
  private void viewAllBook() {
    Util.clearConsole();
    Util.printTable(books);
  }

  // To view all the book that are available
  private void viewAvailableBook() { //yg ini agak bug, dia malah 
    Util.clearConsole();
    ArrayList<Book> availableBooks = getAvailableBook();
    if(availableBooks.size() == 0){
      System.out.println("No Books are currently available...");
      return;
    }
    Util.printTable(availableBooks);
  }

  private ArrayList<Book> getAvailableBook(){
    ArrayList<Book> availableBooks = new ArrayList<>(books);
    availableBooks.removeIf(book -> !book.isAvailable());
    return availableBooks;
  }

    // Member Functions
    public void borrowBook(){
      ArrayList<Book> availableBooks = getAvailableBook();
      if(availableBooks.size()==0){
        System.out.println("No Books are currently available...");
        return;
      }
      viewAllBook();
      int index = getBookIndex(availableBooks);
      Book borrowedBook = availableBooks.get(index);
      System.out.println("You have succesfully borrowed "+borrowedBook.getBookTitle());
      books.remove(borrowedBook);
    }


    // CRUD for the books in library -- Admin

    // Insert a book to the library
    public void insertBook(){
      String title = inputBookTitle();
      String author = inputBookAuthor();
      // ArrayList<Book> books = getAllBooks();
      books.add(new Book(title,author,true));
      System.out.println("Book successfully added to library!");
      Util.cont();
    }
  // Update a book from the library
    public void updateBook(){
      int index = getBookIndex(books);
      // ArrayList<Book> books = getAllBooks();
      Book currBook = books.get(index);
      String title = inputBookTitle();
      String author = inputBookAuthor();
      currBook.updateBook(title, author);
      System.out.println("Book successfully updated!");
      Util.cont();
    }
    // Remove book from the library
    public void deleteBook(){
      int index = getBookIndex(books);
      // ArrayList<Book> books = getAllBooks();
      books.remove(index);
      System.out.println("Book successfully removed!");
      Util.cont();
    }

    private String inputBookTitle(){
      String title = "";
      while(title.isEmpty()){
        System.out.print("Book Title: ");
        title = Util.scanLine();
      }
      return title;
    }

    
    private String inputBookAuthor(){
      String author = "";
      while(author.isEmpty()){
        System.out.print("Book Author: ");
        author = Util.scanLine();
      }
      return author;
    }

    private int getBookIndex(ArrayList<Book> books){
      viewAllBook();
      int index = -1;
      while(!validBookIndex(index, books)){
        System.out.println("Input the Book Number:");
        index = Util.scanInteger();
      }
      return index-1;
    }

    private boolean validBookIndex(int index, ArrayList<Book> books){
      // ArrayList<Book> books = getAllBooks();
      if(index >= 0 || index <= books.size())return true;
      return false;
    }



}
