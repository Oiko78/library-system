package Models;

import java.util.ArrayList;

public class Library {
  public ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
    books.add(new Book("This is title", "This is author"));
  }
}
