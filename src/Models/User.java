package Models;

/**
 * {@code User} class act as a base class for extended class such as
 * {@code Member} and {@code Staff}.
 *
 * @author Oliver Chico
 * @see Models.Member
 * @see Models.Staff
 */
public class User {
  public String name;
  public int age;
  public String email;
  public String password;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User(String email, String password, String name, int age) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.age = age;
  }
}
