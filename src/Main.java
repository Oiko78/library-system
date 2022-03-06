import java.util.Map;

import Menus.*;
import Models.*;

public class Main {
  public Main() {
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

  public static void main(String[] args) {
    new Main();
  }
}
