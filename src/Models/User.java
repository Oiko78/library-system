package Models;

public class User {
  public String name;
  public int age;
  public String email;
  public String password;

  public User(String email, String password, String name, int age) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.age = age;
  }
}
