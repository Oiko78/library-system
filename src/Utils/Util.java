package Utils;

import java.io.IOException;
import java.util.Scanner;

public class Util {
  public static Scanner scan = new Scanner(System.in);

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

  public static void cont() {
    System.out.print("Press enter to continue...");
    scan.nextLine();
  }
}
