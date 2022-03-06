package Helpers;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Util {
  public static Scanner scan = new Scanner(System.in);
  public static Console console = System.console();

  public static void clearConsole() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (InterruptedException | IOException e) {
      // do nothing
    }
  }

  public static void showError(Exception e) {
    System.out.println(e.getMessage());
    cont();
  }

  public static String scanLine(){
    // scans new line and remove white spaces in front and after
    String str = scan.nextLine();
    return str.trim();
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
}
