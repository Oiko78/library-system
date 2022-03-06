package ModelsRework;
import java.util.ArrayList;
import java.util.Scanner;

import Helpers.*;
public class User {

  String name;
  String id;
  String password;
  int age;

  public User(String id, String name, String password, int age) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.age = age;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }


  // Login --> maybe will return int --> index of User in library
  public int login(ArrayList<User> users){
    String id;
    String password;
    int token;
    do{
      System.out.println("Enter id: ");
      id = Util.scanLine();
      System.out.println("Enter Password: ");
      password = Util.scanLine();
      token = validAccount(id, password, users);
    }while(token == -1);
    return token;
  }

  // note: yang ini kepikiran untuk return idx usernya, supaya pas login tinggal pake user itu...
  private int validAccount(String id, String password, ArrayList<User> users) {
    // Loop through existing ArrayList of Users, if found and matches return true
    for(int i = 0; i < users.size(); i++){
      String currId = users.get(i).getId();
      // haven't test this yet:
      if(currId.compareToIgnoreCase(id) == 0){
        String currPassword = users.get(i).getPassword();
        if(currPassword.compareToIgnoreCase(password) == 0)return i;
      }
    }
    return -1;
  }


  // View All Book --> loop through library print book and its status
  public void viewAllBook(Library library){
    for(int i =0; i < library.books.size(); i++){
      Util.printLine();
      Book currBook = library.books.get(i);
      currBook.printBook();
    }
  }
  // View Available Book --> loop through library priint available books

  // Search Book --> Maybe Later :p

  // Tester:
  public static void main(String[] args) {
    User user = new User("kevin", "Kevin Bryan", "123", 20);
    System.out.println("Mulai DISINI:");
    Library library = new Library();
    Book testBook1 = new Book("B001", "Rich Dad Poor Dad", "Robert Kiyosaki", true);
    Book testBook2 = new Book("B002" ,"Psychology of Money", "Steven X", false);
    library.books.add(testBook1);
    library.books.add(testBook2);
    user.viewAllBook(library);
  }
}
