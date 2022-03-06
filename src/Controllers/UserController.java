package Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Models.Staff;
import Models.User;

/**
 * This class controls and manages the flow of a user and also existing user.
 *
 * @author Oliver Chico
 * @see Models.User
 */
public class UserController {
  private Map<String, User> users;
  private User user;

  /**
   * Initialize a {@code Controller} object for a {@code User}. By default,
   * current list of users will only consist of an admin. Users are stored by
   * using its email for the key and the rest of its data for the value.
   * 
   */
  public UserController() {
    this.users = new HashMap<>();

    this.users.put("admin@admin.net", new Staff("admin@admin.net", "Admin123", "Admin", 99));
  }

  /**
   * Get current logged in user
   * 
   * @return a {@code User}
   */
  public User getUser() {
    return user;
  }

  /**
   * Set current logged in user
   * 
   * @return a {@code User}
   */
  private void setUser(User user) {
    this.user = user;
  }

  /**
   * Tries to login with specified email and password.
   * 
   * @param email    a {@code String}
   * @param password a {@code String}
   * @return a true {@code boolean} if exists email and password is valid
   *         otherwise false
   */
  public boolean login(String email, String password) {
    if (!verify(email, password))
      return false;

    setUser(users.get(email));
    return true;
  }

  /**
   * Logout current user by re-initialize current user to null
   * 
   */
  public void logout() {
    setUser(null);
  }

  /**
   * Tries to register an account with specified data while also validate each
   * data. Note that this method already checks for unique user, so unique
   * registered user is guaranteed.
   * 
   * @param email    a {@code String}
   * @param password a {@code String}
   * @param name     a {@code String}
   * @param int      an {@code int}
   * @return a true {@code boolean} if user account is successfully created
   *         otherwise false
   * @throws Exception
   */
  public boolean register(String email, String password, String name, int age) throws Exception {
    if (!verify(email, password, name, age))
      return false;

    User user = new User(email, password, name, age);
    users.put(email, user);
    return true;
  }

  /**
   * Check if specified email is exists on user list
   * 
   * @param email a {@code String}
   * @return a true {@code boolean} if user account exists otherwise false
   */
  public boolean isExistsEmail(String email) {
    return this.users.containsKey(email);
  }

  /**
   * Validate user input for user name while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public boolean validateName(String name) throws Exception {
    if (name.isEmpty())
      throw new Exception("Name must be filled!");

    return true;
  }

  /**
   * Validate user input for user email while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public boolean validateEmail(String email) throws Exception {
    Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    if (email.isEmpty())
      throw new Exception("Email must be filled!");

    Matcher matcher = pattern.matcher(email);
    if (!matcher.find())
      throw new Exception("Please input valid email format");

    if (isExistsEmail(email))
      throw new Exception("This email has already registered!");

    return true;
  }

  /**
   * Validate user input for user password while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public boolean validatePassword(String password) throws Exception {
    if (password.isEmpty())
      throw new Exception("Password must be filled!");

    if (password.length() < 8)
      throw new Exception("Password is too weak!");

    if (!password.matches("^(?=.*[A-Z]).+$"))
      throw new Exception("Password must at least contain 1 uppercase letter!");

    if (!password.matches("^(?=.*[a-z]).+$"))
      throw new Exception("Password must at least contain 1 lowercase letter!");

    if (!password.matches("^(?=.*[0-9]).+$"))
      throw new Exception("Password must at least contain 1 number!");

    return true;
  }

  /**
   * Validate user input for user age while also validating the input
   * accordingly.
   * 
   * @return a validated user-input {@code String}
   */
  public boolean validateAge(int age) throws Exception {
    if (age < -1)
      throw new Exception("Please input valid age!");

    return true;
  }

  /**
   * Verify given email and password when trying to login.
   * 
   * @return a true {@code boolean} if email is exists and password is valid
   *         otherwise false;
   */
  private boolean verify(String email, String password) {
    User user = users.get(email);

    if (user == null)
      return false;

    if (user.password.compareTo(password) != 0)
      return false;

    return true;
  }

  /**
   * Verify given email, password, name, and age when trying to register a user.
   * 
   * @return a true {@code boolean} if all given are valid otherwise false;
   */
  private boolean verify(String email, String password, String name, int age) throws Exception {
    if (validateName(name) &&
        validateEmail(email) &&
        validatePassword(password) &&
        validateAge(age))
      return true;

    return false;
  }
}
