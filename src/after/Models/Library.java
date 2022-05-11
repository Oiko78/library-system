package after.Models;

import java.util.ArrayList;
import java.util.Scanner;

import after.Helpers.Util;

public class Library {
  private ArrayList<Book> books;
  private ArrayList<BookTransaction> transactions;

  public Library() {
    this.books = new ArrayList<Book>();
    this.transactions = new ArrayList<BookTransaction>();
  }

  public Library(ArrayList<Book> books) {
    this.books = books;
    this.transactions = new ArrayList<BookTransaction>();
  }

  public int chooseBook() {
    int index = -1;
    while (!validBookIndex(index)) {
      System.out.println("Input the Book Number:");
      index = Util.scanInteger();
    }
    return index - 1;
  }

  public Book getBook(int index) {
    return books.get(index);
  }

  public Book getBook(String title) {
    for (Book book : books) {
      if (book.getBookTitle().equalsIgnoreCase(title))
        return book;
    }

    return null;
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void removeBook(int index) {
    books.remove(index);
  }

  public void insertBook(Book book) {
    books.add(book);
  }

  public boolean viewBooks(boolean isAvailable) {
    Util.clearConsole();
    ArrayList<Book> books = new ArrayList<>(this.books);

    if (isAvailable) {
      books.removeIf(book -> !book.isAvailable());
    }

    if (books.isEmpty()) {
      System.out.println("No Books are currently available...");
      return false;
    }

    Util.printTable(books);
    return true;
  }

  /**
   * Initialize a library that consist of a list of books for development purpose.
   * 
   * @return {@code ArrrayList<Book>}
   */
  public static Library initializeLibrary() {
    ArrayList<Book> books = new ArrayList<>();
    books.add(new Book("Coding", "Steve Jobs", true));
    books.add(new Book("Programming", "Stevie Wonder", true));
    books.add(new Book("Naruto", "Sasuke Uchiha", false));
    books.add(new Book("Tokyo Ghoul", "Kaneki", true));

    return new Library(books);
  }

  public boolean isExistsBook(String title) {
    for (Book book : books)
      if (book.compareTo(title))
        return true;

    return false;
  }

  private boolean validBookIndex(int index) {
    if (index >= 1 && index <= books.size())
      return true;
    return false;
  }

  public void addTransaction(BookTransaction transaction) {
    System.out.println("abc");
    transactions.add(transaction);
  }

  public void removeTransaction(BookTransaction transaction) {
    transactions
        .removeIf(trx -> trx.getBook().equals(transaction.getBook()) &&
            trx.getUser().equals(transaction.getUser()));
  }
}
