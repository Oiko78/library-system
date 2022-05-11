package after;

import java.util.Map;

import after.Menus.*;
import after.Models.*;

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

      LibraryMenu libraryMenu = new LibraryMenu(library);
      libraryMenu.setUser(user);
      user = libraryMenu.displayMainMenu();
    }
  }
}
