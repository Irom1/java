import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    a();
    b();
    growth();
    diagonally();
  }
  public static void a() {
    System.out.println("a");
    // print 5 lines of "*"
    for (int i = 0; i < 5; i++) {
      System.out.println("*");
    }
  }
  public static void b() {
    System.out.println("b");
    // print "*" 5 times in one line
    for (int i = 0; i < 5; i++) {
      System.out.print("* ");
    }
    System.out.println();
  }
  public static void growth() {
    System.out.println("c");
    // display "*"s in a triangle
    for (int i=1; i<=5; i++) {
      for (int j=1; j<=i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
  public static void diagonally() {
    System.out.println("d");
    // display "*" diagonally
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i == j) {
          System.out.print("*");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
  public static void name() {
    System.out.println("What is your name?");
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    System.out.println("Hello " + name);
    input.close();
  }
}