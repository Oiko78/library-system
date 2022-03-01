import java.util.InputMismatchException;

import Controllers.LibraryController;
import Models.Library;
import Utils.Util;
import Views.LibraryView;

public class App {
  public App(boolean inMenu) {
    Library library = new Library();
    LibraryController libraryController = new LibraryController(library);
    LibraryView libraryMenu = new LibraryView(libraryController);

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
      Util.scan.nextLine();
      switch (input) {
        case 1:
          libraryMenu.InsertMenu(true);
          break;
        case 6:
          libraryMenu.GetAllBookMenu(true);
          break;
        case 7:
          inMenu = false;
          break;
      }
    }
  }

  public static void main(String[] args) {
    new App(true);
  }
}
