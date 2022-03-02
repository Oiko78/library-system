package Views;

import java.util.InputMismatchException;

import Controllers.LibraryController;
import Controllers.UserController;
import Helpers.Util;

public class UserView {
  private UserController userController;
  private LibraryController libraryController;

  public UserView(UserController userController, LibraryController libraryController) {
    this.userController = userController;
    this.libraryController = libraryController;
    mainMenu(true);
  }

  public void mainMenu(boolean inMenu) {
    userController.login("admin@admin.net", "Admin123");

    while (inMenu) {
      if (userController.getUser() != null) {
        LibraryView libraryMenu = new LibraryView(libraryController, userController.getUser());
        userController.logout();
        continue;
      }
      Util.clearConsole();

      System.out.println("Welcome to the library.\nPlease select an action!");
      System.out.println("=======================");
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.println("3. Quit");
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
          loginMenu(true);
          break;
        case 2:
          registerMenu(true);
          break;
        case 3:
          inMenu = false;
          break;
      }
    }
  }

  public void loginMenu(boolean inMenu) {
    String email = "";
    String password = "";

    while (inMenu) {
      Util.clearConsole();

      System.out.println("Login (type quit to cancel)");
      System.out.println("=======================");
      try {
        System.out.print("Email: " + (email.isEmpty() ? "" : email + "\n"));
        email = email.isEmpty() ? userController.getEmail(false) : email;
        if (email.compareToIgnoreCase("quit") == 0)
          return;

        System.out.print("Password: " + (password.isEmpty() ? "" : password + "\n"));
        password = password.isEmpty() ? userController.getPassword(false) : password;
        if (password.compareToIgnoreCase("quit") == 0)
          return;

      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
        continue;
      }

      inMenu = false;
    }

    Util.clearConsole();
    boolean success = userController.login(email, password);
    System.out.println(success ? "Login successfull." : "Failed to login!\nPlease check your email or password!");
    Util.cont();

    if (!success)
      loginMenu(true);
  }

  public void registerMenu(boolean inMenu) {
    String email = "";
    String password = "";
    String name = "";
    int age = -1;

    while (inMenu) {
      Util.clearConsole();

      System.out.println("Register (type quit to cancel)");
      System.out.println("=======================");
      try {
        System.out.print("Name: " + (name.isEmpty() ? "" : name + "\n"));
        name = name.isEmpty() ? userController.getName() : name;
        if (name.compareToIgnoreCase("quit") == 0)
          return;

        System.out.print("Age: " + (age == -1 ? "" : age + "\n"));
        age = age == -1 ? userController.getAge() : age;
        if (age == -1)
          return;

        System.out.print("Email: " + (email.isEmpty() ? "" : email + "\n"));
        email = email.isEmpty() ? userController.getEmail(true) : email;
        if (email.compareToIgnoreCase("quit") == 0)
          return;

        System.out.print("Password: " + (password.isEmpty() ? "" : password + "\n"));
        password = password.isEmpty() ? userController.getPassword(true) : password;
        if (password.compareToIgnoreCase("quit") == 0)
          return;

      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
        continue;
      }

      inMenu = false;
    }

    Util.clearConsole();
    boolean success = userController.register(email, password, name, age);
    System.out.println(success ? "Account has successfully registered." : "Register failed!");
    Util.cont();
  }
}
