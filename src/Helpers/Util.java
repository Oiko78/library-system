package Helpers;

import java.io.Console;
import java.io.IOException;
import java.util.List;
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
    System.out.print("Input here: ");
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

  public static <T> void printTable(List<T> objects) {
    boolean odd = false;
    System.out.println("=======================");
    for (int i = 0; i < objects.size(); i++) {
      System.out.println(objects.get(i));
      if (i == objects.size() - 1)
        continue;

      System.out.println("-----------------------");
    }
    System.out.println("=======================");
  }

  public static <T> void printTable(List<T> objects, String title) {
    System.out.println(title);
    printTable(objects);
  }
}
