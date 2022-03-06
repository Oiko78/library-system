// package Views;

// import Controllers.LibraryController;
// import Controllers.UserController;
// import Helpers.Util;
// import Models.Library;
// import Models.User;

// public class UserView {
//   private UserController controller;

//   public UserView(UserController controller) {
//     this.controller = controller;
//   }

//   public void mainMenu(boolean inMenu) {
//     controller.login("admin@admin.net", "Admin123");
//     Library library = new Library();

//     while (inMenu) {
//       if (controller.getUser() != null) {
//         LibraryController libraryController = new LibraryController(library);
//         LibraryView libraryMenu = new LibraryView(libraryController, controller.getUser());
//         libraryMenu.mainMenu();
//         controller.logout();
//         continue;
//       }
//       Util.clearConsole();

//       System.out.println("Welcome to the library.\nPlease select an action!");
//       System.out.println("=======================");
//       System.out.println("1. Login");
//       System.out.println("2. Register");
//       System.out.println("3. Quit");
//       System.out.print(">> ");

//       int input = -1;
//       try {
//         input = Util.scan.nextInt();
//       } catch (Exception e) {
//         Util.clearConsole();
//         Util.showError(e);
//       }

//       // Untuk clar buffer "enter" karena nextInt hanya read number, jadi masih ada
//       // buffer "enter"
//       Util.scan.nextLine();

//       switch (input) {
//         case 1:
//           loginMenu(true);
//           break;
//         case 2:
//           registerMenu(true);
//           break;
//         case 3:
//           inMenu = false;
//           break;
//       }
//     }
//   }

//   public void loginMenu(boolean inMenu) {
//     User user = null;

//     while (inMenu) {
//       Util.clearConsole();

//       System.out.println("Login (type quit to cancel)");
//       System.out.println("=======================");
//       try {
//         user = getUserCredential();
//         if (user == null)
//           return;

//         Util.clearConsole();
//         boolean success = controller.login(user.email, user.password);
//         System.out.println(success ? "Login successfull." : "Failed to login!\nPlease check your email or password!");
//         Util.cont();
//         if (success)
//           return;

//       } catch (Exception e) {
//         Util.clearConsole();
//         Util.showError(e);
//       }
//     }
//   }

//   public void registerMenu(boolean inMenu) {
//     User user = null;

//     while (inMenu) {
//       Util.clearConsole();

//       System.out.println("Register (type quit to cancel)");
//       System.out.println("=======================");
//       try {
//         user = getUserData();
//         if (user == null)
//           return;

//         Util.clearConsole();
//         boolean success = controller.register(user.email, user.password, user.name, user.age);
//         System.out.println(success ? "Account has successfully registered." : "Register failed!");
//         Util.cont();
//         if (success)
//           return;

//       } catch (Exception e) {
//         Util.clearConsole();
//         Util.showError(e);
//       }
//     }
//   }

//   public User getUserData() throws Exception {
//     String email = "", password = "", name = "";
//     int age = -1;

//     System.out.print("Name: " + (name.isEmpty() ? "" : name + "\n"));
//     if (name.isEmpty())
//       name = Util.scan.nextLine();

//     if (Util.quitMenu(name))
//       return null;

//     System.out.print("Age: " + (age <= -1 ? "" : age + "\n"));
//     if (age <= -1) {
//       age = Util.scan.nextInt();
//     }

//     if (age <= -1)
//       return null;

//     System.out.print("Email: " + (email.isEmpty() ? "" : email + "\n"));
//     if (email.isEmpty())
//       email = Util.scan.nextLine();

//     if (Util.quitMenu(email))
//       return null;

//     System.out.print("Password: " + (password.isEmpty() ? "" : password + "\n"));
//     if (password.isEmpty())
//       password = new String(Util.console.readPassword());

//     if (Util.quitMenu(password))
//       return null;

//     return new User(email, password, name, age);
//   }

//   public User getUserCredential() throws Exception {
//     String email = "", password = "";

//     System.out.print("Email: " + (email.isEmpty() ? "" : email + "\n"));
//     if (email.isEmpty())
//       email = Util.scan.nextLine();

//     if (Util.quitMenu(email))
//       return null;

//     System.out.print("Password: " + (password.isEmpty() ? "" : password + "\n"));
//     if (password.isEmpty())
//       password = new String(Util.console.readPassword());

//     if (Util.quitMenu(password))
//       return null;

//     return new User(email, password);
//   }
// }
