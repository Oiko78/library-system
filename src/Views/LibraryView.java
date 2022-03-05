package Views;

import java.util.ArrayList;

import Controllers.LibraryController;
import Helpers.Util;
import Models.Book;
import Models.Member;
import Models.Staff;
import Models.User;

public class LibraryView {
  private LibraryController controller;
  private User user;

  public LibraryView(LibraryController controller, User user) {
    this.controller = controller;
    this.user = user;
  }

  public void mainMenu() {
    if (user instanceof Member)
      memberMainMenu(true);

    if (user instanceof Staff)
      staffMainMenu(true);
  }

  public void memberMainMenu(boolean inMenu) {
    while (inMenu) {
      Util.clearConsole();

      System.out.printf("Hello %s.\nPlease select an action!\n", user.name);
      System.out.println("=======================");
      System.out.println("1. Borrow Book");
      System.out.println("2. Return Book");
      System.out.println("3. Get Available Book");
      System.out.println("4. Get All Book");
      System.out.println("5. Quit");
      System.out.print(">> ");

      int input = -1;
      try {
        input = Util.scan.nextInt();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }

      // Untuk clear buffer "enter" karena nextInt hanya read number, jadi masih ada
      // buffer "enter" yang harus ditangkap
      Util.scan.nextLine();

      switch (input) {
        case 4:
          getAllBookMenu(true);
          break;
        case 5:
          inMenu = false;
          break;
      }
    }
  }

  public void staffMainMenu(boolean inMenu) {
    while (inMenu) {
      Util.clearConsole();

      System.out.printf("Hello %s.\nPlease select an action!\n", user.name);
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

      // Untuk clear buffer "enter" karena nextInt hanya read number, jadi masih ada
      // buffer "enter" yang harus ditangkap
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
        title = title.isEmpty() ? controller.getBookTitle() : title;
        if (title.compareToIgnoreCase("quit") == 0)
          return;

        System.out.print("Book author: " + (author.isEmpty() ? "" : author + "\n"));
        author = author.isEmpty() ? controller.getBookAuthor() : author;
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
    boolean success = controller.insertBook(title, author);
    System.out.printf((success ? "successfully inserted book %s.\n" : "failed to insert book %s!\n"), title);
    Util.cont();
    return;
  }

  public void getAllBookMenu(boolean inMenu) {
    Util.clearConsole();

    ArrayList<Book> books = controller.getAllBooks();
    if (books.size() == 0) {
      System.out.println("Library currently has no book to read!\nPlease come backlater.");
      Util.cont();
      return;
    }

    displayBookTable(books);
  }

  public void displayBookTable(ArrayList<Book> books) {
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
