package before.Menus;

import java.util.Map;

import before.Models.Member;
import before.Models.User;
import before.Helpers.Util;

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
 * @author Nicholas Indra Wijaa
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

  
  // [Comments]
  //Display Main Menu
  public User dmm() {
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
        // Display Register Menu
          drm();
          break;
        case 2:
        // Display Login Menu
        return dlm();
        case 3:
          inMenu = false;
          break;
      }
    }
    return null;
  }

  // Display Register Method
  private void drm() {
    User user = null;
    while (user == null) {
      Util.clearConsole();
      System.out.println("Register");
      System.out.println("===============");
      try {
        // Get Register Data
        user = grd();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }
    }

    if (user != null)
      users.put(user.email, user);
  }

  // Display Login Menu
  private User dlm() {
    User user = null;
    while (user == null) {
      Util.clearConsole();
      System.out.println("Login");
      System.out.println("===============");
      try {
        // Get Login Data
        user = gld();
      } catch (Exception e) {
        Util.clearConsole();
        Util.showError(e);
      }
    }
    return user;
  }

  // Get Register Data
  private User grd() throws Exception {
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



  // Get Login Data
  private User gld() throws Exception {
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

  //[Dead Code]
  private int getPasswordLength(String password){
    return password.length();
  }

  private boolean isExistsEmail(String email) {
    return users.containsKey(email);
  }
}

