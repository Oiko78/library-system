package Helpers;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * This {@code Util} class provides methods to help preventing code redundancy.
 *
 * @author Oliver Chico
 * @see Scanner
 * @see Console
 */
public class Util {
  public static Scanner scan = new Scanner(System.in);
  public static Console console = System.console();

  /**
   * Clears out console from any text that has been shown previously.
   */
  public static void clearConsole() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (InterruptedException | IOException e) {
      // do nothing
    }
  }

  /**
   * Displays error message from provided exception.
   */
  public static void showError(Exception e) {
    System.out.println(e.getMessage());
    cont();
  }

  public static String scanLine(){
    // scans new line and remove white spaces in front and after
    String str = scan.nextLine();
    return str.trim();
  }

  
  public static int scanInteger(){
    // scans new line and remove white spaces in front and after, and convertes to integer
    String str = scan.nextLine();
    return Integer.parseInt(str.trim());
  }

  public static void cont() {
    System.out.print("Press enter to continue...");
    scan.nextLine();
  }
  public static void printLine(){
    System.out.println("==========================");
  }
  public static void printTitle(){
    System.out.println("GoLibrary 📖");
  }
  public static void printGetInput(){
    System.out.print("Input here: ");
  }

  public static boolean quitMenu(String query) {
    if (query.compareToIgnoreCase("quit") == 0)
      return true;
    return false;
  }
}
