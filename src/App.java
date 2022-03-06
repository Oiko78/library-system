import Controllers.UserController;
import Views.UserView;

public class App {
  public App(boolean inMenu) {
    UserController userController = new UserController();
    UserView userMenu = new UserView(userController);
    userMenu.mainMenu(true);
  }

  public static void main(String[] args) {
    new App(true);
  }
}
