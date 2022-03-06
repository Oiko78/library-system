package Views;

import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.LibraryController;
import Helpers.Util;
import Models.Book;
import Models.User;

public class LibraryView {
  private LibraryController libraryController;

  public LibraryView(LibraryController libraryController, User user) {
    this.libraryController = libraryController;
    this.libraryController.user = user;
    mainMenu(true);
  }

  public void adminMenu(boolean inMenu){
    while (inMenu) {
      Util.clearConsole();

      System.out.printf("Hello %s.\nPlease select an action!\n", libraryController.user.name);
      System.out.println("=======================");
      System.out.println("1. Insert Book");
      System.out.println("2. Delete Book");
      System.out.println("3. Update Book Detail");
      // Update book detail anggap sudah mencakup 
      System.out.println("4. Update Book Status");
      System.out.println("5. Get Available Book");
      System.out.println("6. Get All Book");
      System.out.println("7. Quit");
      System.out.print(">> ");

      int input = -1;
      try {
        input = Util.scan.nextInt();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }

      // Untuk clar buffer "enter" karena nextInt hanya read number, jadi masih ada
      // buffer "enter"
      Util.scan.nextLine();

      switch (input) {
        case 1:
          insertMenu(true);
          break;
        case 6:
          getAllBookMenu(true);
          break;
        case 7:
          inMenu = false;
          break;
      }
    }
  }

  public void mainMenu(boolean inMenu) {
    while (inMenu) {
      Util.clearConsole();

      System.out.printf("Hello %s.\nPlease select an action!\n", libraryController.user.name);
      System.out.println("=======================");
      System.out.println("1. Insert Book");
      System.out.println("2. Delete Book");
      System.out.println("3. Update Book Detail");
      System.out.println("4. Update Book Status");
      System.out.println("5. Get Available Book");
      System.out.println("6. Get All Book");
      System.out.println("7. Quit");
      System.out.print(">> ");

      int input = -1;
      try {
        input = Util.scan.nextInt();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }

      // Untuk clar buffer "enter" karena nextInt hanya read number, jadi masih ada
      // buffer "enter"
      Util.scan.nextLine();

      switch (input) {
        case 1:
          insertMenu(true);
          break;
        case 6:
          getAllBookMenu(true);
          break;
        case 7:
          inMenu = false;
          break;
      }
    }
  }

  public void insertMenu(boolean inMenu) {
    String title = "";
    String author = "";

    while (inMenu) {
      Util.clearConsole();

      System.out.println("Insert book data! (type quit to cancel)");
      System.out.println("=======================");
      try {
        System.out.print("Book title: " + (title.isEmpty() ? "" : title + "\n"));
        title = title.isEmpty() ? libraryController.getBookTitle() : title;
        if (title.compareToIgnoreCase("quit") == 0)
          return;

        System.out.print("Book author: " + (author.isEmpty() ? "" : author + "\n"));
        author = author.isEmpty() ? libraryController.getBookAuthor() : author;
        if (author.compareToIgnoreCase("quit") == 0)
          return;

      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
        continue;
      }

      inMenu = false;
    }

    Util.clearConsole();
    boolean success = libraryController.insertBook(title, author);
    System.out.printf((success ? "successfully inserted book %s.\n" : "failed to insert book %s!\n"), title);
    Util.cont();
    return;
  }

  public void getAllBookMenu(boolean inMenu) {
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
