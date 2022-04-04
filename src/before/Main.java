package before;

import java.util.Map;

import before.Menus.*;
import before.Models.*;

public class Main {
  public static void main(String[] args) {
    Library library = Library.initializeLibrary();
    Map<String, User> users = User.initializeUsers();
    User user = null;

    boolean inMenu = true;
    while (inMenu) {
      UserMenu userMenu = new UserMenu(users);
      user = userMenu.displayMainMenu();

      if (user == null)
        break;

      LibraryMenu libraryMenu = new LibraryMenu(library, user);
      user = libraryMenu.displayMainMenu();
    }
  }
}
