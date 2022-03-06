package Helpers;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * This {@code Util} class provides methods to help preventing code redundancy.
 *
 * @author Oliver Chico
 * @author Kevin Bryan
 * 
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

  /**
   * Scans a line and remove trailing white spaces
   */
  public static String scanLine() {
    String str = scan.nextLine();
    return str.trim();
  }

  /**
   * Scans a line and remove trailing white spaces then convert it to an integer
   */
  public static int scanInteger() {
    return Integer.parseInt(scanLine());
  }

  public static void cont() {
    System.out.print("Press enter to continue...");
    scan.nextLine();
  }
}
