import Helpers.Util;
import ModelsRework.*;

public class Main {
  public static void menu(Library library){
    User user =  new User("id", "name", "password", 1);
    int choice = 0;
    do{
      Util.printTitle();
    // kekny login bisa dibikin string function, kalo admin return admin , kalo g return nama member :V, kalo login return admin tampilin
    // admin menu
      System.out.println("1. Register as a new Member");
      System.out.println("2. Login as Member");
      System.out.println("3. Login as Admin");
      System.out.println("4. Exit");

      choice = Integer.parseInt(Util.scanLine());
      switch (choice) {
        case 1://Register as a new Member --> kalo dah regis langusng ke login aja (logout dipikirkan nanti :V)
        Member member = new Member();
        member = member.register(library.users);
        break;
        case 2://Login as a member
        // int userIndex = user.login(library.users);
        // Member member = library.users.get(userIndex);
        user.login(library.users);
        break;
        case 3://Login as an admin
        Staff admin = new Staff("id", "name", "password", 0);
        admin.login(library.users);
        admin.staffMenu(library);

        break;
        case 4://Exit
        System.out.println("Thanks for using our program!");
        break;
        default:
        System.out.println("Please enter");
          break;
      }
    }while(choice < 1 || choice > 4);
  }


  public static void main(String[] args) {
    Library library = new Library();
    // User user = new User();
    Staff admin = new Staff("admin", "Anonymous", "123", 99);
    menu(library);
  }
}
