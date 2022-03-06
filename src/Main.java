import Helpers.Util;
import ModelsRework.*;

public class Main {
  public static void menu(Library library){
    User user =  new User("id", "name", "password", 1);
    int choice = 0;
    do{
      Util.printTitle();
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Exit");
      Util.printGetInput();
      choice = Util.scanInteger();
      switch (choice) {
        case 1://Register as a new Member
          Member member = new Member();
          member = member.register(library.users);
          member.memberMenu(library);
          break;
        case 2://Login
          int token = user.login(library.users);
          if(token == 0){
            Staff staff = (Staff) library.users.get(token);
            staff.staffMenu(library);
          }else{
            member = (Member) library.users.get(token);
            member.memberMenu(library);
          }
          break;
        case 3://Exit
          System.out.println("Thanks for using our program!");
        break;
        default:
          System.out.println("Please enter within range!");
          break;
      }
    }while(choice < 1 || choice > 4);
  }


  public static void main(String[] args) {
    Library library = new Library();
    menu(library);
  }
}
