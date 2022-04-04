package after.Models;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code User} class represents a user that has attributes such as name, age,
 * email, and password.
 * 
 * <p>
 * Usage example:
 * <blockquote>
 * 
 * <pre>
 * User user = new User("email", "password", "name", 20);
 * 
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * @author Oliver Chico
 * @author Kevin Bryan
 */
public class User {
  public String name;
  public String email;
  public String password;
  public int age;

  public User(String email, String password, String name, int age) {
    this.name = name;
    this.password = password;
    this.age = age;
    this.email = email;
  }

  /**
   * Displays formatted book's attributes.
   */
  @Override
  public String toString() {
    String str = "";
    str = str.concat("name: " + name + "\n");
    str = str.concat("email: " + email + "\n");
    str = str.concat("password: " + password + "\n");
    str = str.concat("age: " + age);

    return str;
  }

  /**
   * Initialize a list of users for development purpose.
   * 
   * @return {@code Map<string, User>}
   */
  public static Map<String, User> initializeUsers() {
    Map<String, User> users = new HashMap<>();
    users.put("admin", new Staff("admin", "admin", "admin", 01));
    users.put("dummy", new Member("dummy", "dummy", "dummy", 99));

    return users;
  }
}
