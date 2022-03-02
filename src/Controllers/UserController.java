package Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Helpers.Util;
import Models.User;

public class UserController {
  private Map<String, User> users;
  private User user;

  public UserController() {
    this.users = new HashMap<>();

    this.users.put("admin@admin.net", new User("admin@admin.net", "Admin123", "Admin", 99));
  }

  public User getUser() {
    return user;
  }

  public boolean login(String email, String password) {
    if (!verify(email, password))
      return false;

    this.user = users.get(email);
    return true;
  }

  public void logout() {
    this.user = null;
  }

  public boolean register(String email, String password, String name, int age) {
    if (email.isEmpty() || password.isEmpty() ||
        name.isEmpty() || age == -1)
      return false;

    User user = new User(email, password, name, age);
    users.put(email, user);
    return true;
  }

  public String getName() throws Exception {
    try {
      String name = Util.scan.nextLine();
      if (name.isEmpty())
        throw new Exception("Name must be filled!");

      if (name.compareToIgnoreCase("quit") == 0)
        return "quit";

      return name;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  public String getEmail(boolean validate) throws Exception {
    Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    try {
      String email = Util.scan.nextLine();
      if (email.isEmpty())
        throw new Exception("Email must be filled!");

      if (email.compareToIgnoreCase("quit") == 0)
        return "quit";

      if (!validate)
        return email;

      Matcher matcher = pattern.matcher(email);
      if (!matcher.find())
        throw new Exception("Please input valid email format");

      if (this.users.containsKey("email"))
        throw new Exception("This email has already registered!");

      return email;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  public String getPassword(boolean validate) throws Exception {
    try {
      String password = new String(Util.console.readPassword());
      if (password.isEmpty())
        throw new Exception("Password must be filled!");

      if (password.compareToIgnoreCase("quit") == 0)
        return "quit";

      if (!validate)
        return password;

      if (password.length() < 8)
        throw new Exception("Password is too weak!");

      if (!password.matches("^(?=.*[A-Z]).+$"))
        throw new Exception("Password must at least contain 1 uppercase letter!");

      if (!password.matches("^(?=.*[a-z]).+$"))
        throw new Exception("Password must at least contain 1 lowercase letter!");

      if (!password.matches("^(?=.*[0-9]).+$"))
        throw new Exception("Password must at least contain 1 number!");

      String confirmPassword = new String(Util.console.readPassword("Confirm Password: "));

      if (password.compareTo(confirmPassword) != 0)
        throw new Exception("Password does not match!");

      return password;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  public int getAge() throws Exception {
    try {
      int age = Util.scan.nextInt();
      Util.scan.nextLine();

      if (age < -1)
        throw new Exception("Please input valid age!");

      return age;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  public Boolean verify(String email, String password) {
    if (!users.containsKey(email))
      return false;

    if (users.get(email).password.compareTo(password) != 0)
      return false;

    return true;
  }
}
