import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controllers.LibraryController;
import Models.Library;
import Views.LibraryView;

public class App {
  public App(boolean inMenu) {
    Library library = new Library();
    LibraryController libraryController = new LibraryController(library);
    LibraryView libraryMenu = new LibraryView(libraryController);

  }

  public static void main(String[] args) {
    new App(true);
    // Pattern pattern = Pattern.compile("[a-zA-Z]{2}");
    // Matcher matcher = pattern.matcher("AA");
    // System.out.println(matcher.find());
  }
}
