import Controllers.LibraryController;
import Controllers.UserController;
import Models.Library;
import Views.UserView;

public class App {
  public App(boolean inMenu) {
    Library library = new Library();
    LibraryController libraryController = new LibraryController(library);

    UserController userController = new UserController();
    UserView userMenu = new UserView(userController, libraryController);
  }

  public static void main(String[] args) {
    new App(true);
  }
}
