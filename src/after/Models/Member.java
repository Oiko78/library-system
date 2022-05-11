package after.Models;

import java.util.ArrayList;

import after.Helpers.Util;

public class Member extends User {
  private ArrayList<Book> books;

  public Member(String email, String password, String name, int age) {
    super(email, password, name, age);
    books = new ArrayList<Book>();
  }

  public boolean viewBooks() {
    Util.clearConsole();
    ArrayList<Book> books = new ArrayList<>(this.books);

    if (books.isEmpty()) {
      System.out.println("You have no books...");
      return false;
    }

    Util.printTable(books);
    return true;
  }

  public BookTransaction borrowBook(Book book) {
    books.add(book);
    book.setAvailable(false);
    return new BookTransaction(this, book);
  }

  public BookTransaction returnBook(Book book) {
    books.remove(book);
    book.setAvailable(true);
    return new BookTransaction(this, book);
  }

  public Book getBook(String title) {
    for (Book book : books) {
      if (book.getBookTitle().equalsIgnoreCase(title))
        return book;
    }

    return null;
  }
}
