package Models;

/**
 * This {@code Staff} class represent a user that can do some queries to
 * library system such as inserting new book or updating existing book.
 *
 * @author Oliver Chico
 */
public class Staff extends User {

  public Staff(String email, String password) {
    super(email, password);
  }

  public Staff(String email, String password, String name, int age) {
    super(email, password, name, age);
  }
}
