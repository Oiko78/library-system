package Menus;

import java.util.Map;

import Helpers.Util;
import Models.Member;
import Models.User;

/**
 * {@code UserMenu} class represents a menu that will displays some action
 * related to authentication for
 * {@code User} such as register, login, and logout.
 * 
 * <p>
 * Usage example:
 * <blockquote>
 * 
 * <pre>
 * Map<String, User> users = new HashMap<>();
 * users.put(new Staff("admin", "admin", "admin", 20));
 * users.put(new Member("dummy", "dummy", "dummy", 20));
 * 
 * UserMenu userMenu = new UserMenu(users);
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * 
 * @author Oliver Chico
 * @author Kevin Bryan
 * 
 * @see Models.User
 * @see Models.Staff
 * @see Models.Member
 */
public class UserMenu {
  private Map<String, User> users;

  /**
   * Initialize a new instance of {@code UserMenu}
   * 
   * @param users a list of registered user
   */
  public UserMenu(Map<String, User> users) {
    this.users = users;
  }

  /**
   * Displays default actions that user can choose.
   */
  public User displayMainMenu() {
    boolean inMenu = true;
    while (inMenu) {
      Util.clearConsole();
      System.out.println("GoLibrary 📖");
      System.out.println("===============");
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Exit");
      System.out.print("Input here: ");

      int menu = -1;
      try {
        menu = Util.scanInteger();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }

      switch (menu) {
        case 1:
          displayRegisterMenu();
          break;
        case 2:
          return displayLoginMenu();
        case 3:
          inMenu = false;
          break;
      }
    }
    return null;
  }

  private void displayRegisterMenu() {
    User user = null;
    while (user == null) {
      Util.clearConsole();
      System.out.println("Register");
      System.out.println("===============");
      try {
        user = getRegisterData();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }
    }

    if (user != null)
      users.put(user.email, user);
  }

  private User getRegisterData() throws Exception {
    String email = "", password = "", confirmPassword = "", name = "";
    int age = -1;

    System.out.print("Enter your name: ");
    name = Util.scan.nextLine();

    try {
      System.out.print("Enter your age: ");
      age = Util.scan.nextInt();
      Util.scan.nextLine();
    } catch (Exception e) {
      Util.scan.nextLine();
      throw new Exception("Age must be a number!");
    }
    if (false) // TODO: add age validation
      throw new Exception("Please input a valid age!");

    System.out.print("Enter your email: ");
    email = Util.scan.nextLine();
    if (isExistsEmail(email))
      throw new Exception("Email must be unique!");

    System.out.print("Enter your password: ");
    password = new String(Util.console.readPassword());
    if (false) // TODO: add password validation
      throw new Exception("Invalid password!");

    System.out.print("Confirm your password: ");
    confirmPassword = new String(Util.console.readPassword());
    if (!isValidPassword(password, confirmPassword))
      throw new Exception("Password does not match!");

    System.out.println("\nAccount has been registered.");
    Util.cont();
    return new Member(email, password, name, age);
  }

  private User displayLoginMenu() {
    User user = null;
    while (user == null) {
      Util.clearConsole();
      System.out.println("Login");
      System.out.println("===============");
      try {
        user = getLoginData();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }
    }
    return user;
  }

  private User getLoginData() throws Exception {
    User user = null;
    String email = "", password = "";

    System.out.print("Enter your email: ");
    email = Util.scan.nextLine();
    if (!isExistsEmail(email))
      throw new Exception("Email does not exists!");

    user = users.get(email);

    System.out.print("Enter your password: ");
    password = new String(Util.console.readPassword());
    if (!isValidPassword(password, user.password))
      throw new Exception("Invalid password!");

    System.out.println("\nLogin success.");
    Util.cont();
    return user;
  }

  private boolean isValidPassword(String password, String confirmPassword) {
    return password.compareTo(confirmPassword) == 0;
  }

  private boolean isExistsEmail(String email) {
    return users.containsKey(email);
  }
}
