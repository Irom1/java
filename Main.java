import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean testing = false;
    String string1, string2, string3, string4, string5;
    if (!testing) {
      // get input for scanner
      Scanner input = new Scanner(System.in);
      string1 = input.nextLine();
      string2 = input.nextLine();
      string3 = input.nextLine();
      string4 = input.nextLine();
      string5 = input.nextLine();
      input.close();
    } else {
      // input defualt values for testing
      string1 = "MISSISSIPPI, 2, *";
      string2 = "MISSISSIPPI, IS";
      string3 = "MISSISSIPPI, P";
      string4 = "MISSISSIPPI, I";
      string5 = "MISSISSIPPI, 2, I";
      /*
MISSISSIPPI, 2, *
MISSISSIPPI, IS
MISSISSIPPI, P
MISSISSIPPI, I
MISSISSIPPI, 2, I
       */
    }
    // parse "MISSISSIPPI, 2, *" into char_split("MISSISSIPPI", 2, '*')
    String[] split = string1.split(", ");
    String a$ = split[0];
    int n = Integer.parseInt(split[1]);
    char c = split[2].charAt(0);
    System.out.println(Strings.char_split(a$, n, c));
    // parse "MISSISSIPPI, IS" into strrem("MISSISSIPPI", "IS")
    split = string2.split(", ");
    a$ = split[0];
    String b$ = split[1];
    System.out.println(Strings.strrem(a$, b$));
    // parse "MISSISSIPPI, P" into strchr("MISSISSIPPI", "P")
    split = string3.split(", ");
    a$ = split[0];
    b$ = split[1];
    System.out.println(Strings.strchr(a$, b$));
    // parse "MISSISSIPPI, I" into strtok("MISSISSIPPI", "I")
    split = string4.split(", ");
    a$ = split[0];
    b$ = split[1];
    System.out.println(Strings.strtok(a$, b$));
    // parse "MISSISSIPPI, 2, I" into wordwrap("MISSISSIPPI", 2, "I")
    split = string5.split(", ");
    a$ = split[0];
    n = Integer.parseInt(split[1]);
    b$ = split[2];
    System.out.println(Strings.wordwrap(a$, n, b$));
  }
}