package ModelsRework;

import Helpers.Util;

public class Staff extends User {

  public Staff(String id, String name, String password, int age) {
    super(id, name, password, age);
  }
  
  // Insert book
  // Update book
  // Delete book
  // View All Existing Member

  public void staffMenu(Library library){
    // View All Book
    // View all available books
    // Borrow Book
    // Return Book
    int choice = 0;
    do{

      System.out.println("1. View All Books");
      System.out.println("2. View Avaialble Books");
      System.out.println("3. Add a Book");
      System.out.println("4. Update a Book");
      System.out.println("5. Delete a Book");
      System.out.println("6. See all Members");//start from users[i]
      System.out.println("7. Exit");
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
