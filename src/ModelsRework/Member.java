package ModelsRework;
import java.util.ArrayList;

import Helpers.Util;

public class Member extends User{

  public Member(String id, String password, String name, int age) {
    super(id, password, name, age);
  }

  public Member() {
    super("Guest","-","-", 0);
  }

  // Register
  public Member register(ArrayList<User> users){
    String id, password, name;
    int age = 0;
    // Name
    System.out.println("Enter your name:");
    name = Util.scanLine();
    // Age
    try{
      System.out.println("Enter your age:");
      age = (int) Integer.parseInt(Util.scanLine());
    }catch(Exception e){
      System.out.println("Age must be a number!");
    }
    // ID
    do{
      System.out.println("Enter your id:");
      id = Util.scanLine(); 
    }while(!uniqueID(id, users));
    // Password
    System.out.println("Enter your password:");
    password = Util.scanLine();//validasi password (validation not made yet)
    Member newMember = new Member(name, password, id, age);
    return newMember;
  }
// Function to make sure the new id is unique
  private boolean uniqueID(String id,  ArrayList<User> users) {
    //loop through Array List --> if found return false
    for(int i = 0; i < users.size(); i++){
      String currId = users.get(i).getId();
      // haven't test this yet:
      if(currId == id) return false;
    }
    return true;
  }

  // Borrow Book --> search book, check if book exist --> available/ set book status to borrowed
  // Return Book --> search book, check if book exist --> set book status to available
  
  public void memberMenu(Library library){
    // View All Book
    // View all available books
    // Borrow Book
    // Return Book
    int choice = 0;
    do{
      System.out.println("1. View All Books");
      System.out.println("2. View Avaialble Books");
      System.out.println("3. Borrow a Book");
      System.out.println("4. Return a Book");
      System.out.println("5. Exit");
      Util.printGetInput();
      choice = Util.scanInteger();
      
      switch (choice) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        default:
          break;
      }
    }while(choice < 1 || choice > 5);
  }

  
}
