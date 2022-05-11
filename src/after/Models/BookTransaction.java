package after.Models;

import java.util.Date;

public class BookTransaction {
  private User user;
  private Book book;
  private DateRange date;

  public BookTransaction(User user, Book book) {
    this.user = user;
    this.book = book;
    this.date = new DateRange();
  }

  public void setBorrowDate(Date date) {
    this.date.setStart(date);
  }

  public void setReturnDate(Date date) {
    this.date.setEnd(date);
  }

  public User getUser() {
    return user;
  }

  public Book getBook() {
    return book;
  }
}
