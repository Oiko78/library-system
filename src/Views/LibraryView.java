package Views;

import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.LibraryController;
import Models.Book;
import Utils.Util;

public class LibraryView {
  LibraryController libraryController;

  public LibraryView(LibraryController libraryController) {
    this.libraryController = libraryController;
    mainMenu(true);
  }

  public void mainMenu(boolean inMenu) {
    while (inMenu) {
      Util.clearConsole();

      System.out.println("Welcome to the library.\nPlease select an action!");
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
      } catch (InputMismatchException e) {
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
