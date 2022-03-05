package Models;

/**
 * This {@code Member} class represent a user that can only read and borrows
 * book in the library.
 *
 * @author Oliver Chico
 */
public class Member extends User {

  public Member(String email, String password) {
    super(email, password);
  }

  public Member(String email, String password, String name, int age) {
    super(email, password, name, age);
  }
}
