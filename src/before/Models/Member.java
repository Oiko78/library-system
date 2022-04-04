package before.Models;

import java.util.ArrayList;

public class Member extends User {
  private ArrayList<Book> books;

  public Member(String email, String password, String name, int age) {
    super(email, password, name, age);
    books = new ArrayList<Book>();
  }

  public ArrayList<Book> getBooks() {
    return new ArrayList<Book>(books);
  }

  public void borrowBook(Book book) {
    books.add(book);
    book.changeStatus();
  }

  public void returnBook(Book book) {
    books.remove(book);
    book.changeStatus();
  }
}
