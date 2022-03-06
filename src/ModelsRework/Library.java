package ModelsRework;
import java.util.ArrayList;


public class Library {
  public ArrayList<Book> books;
  public ArrayList<User> users;

  public Library() {
    this.books = new ArrayList<Book>();
    this.users = new ArrayList<User>();
    Staff admin = new Staff("admin", "Anonymous", "123", 99);
    this.users.add(admin);// admin is set from the start and will always be index no 0

    // dummy books
    this.books.add(new Book("B001", "Coding", "Steve Jobs", true));
    this.books.add(new Book("B002", "Programming", "Stevie Wonder", true));
    this.books.add(new Book("B003", "Naruto", "Sasuke Uchiha", false));
    this.books.add(new Book("B004", "Tokyo Ghoul", "Kaneki", true));
  }
}

