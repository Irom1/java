import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean testing = true;
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
      string1 = "[ 2 + 3 * 8 - 3 ) ] + 6";
      string2 = "[ ( 2 - 5 ) + 6";
      string3 = "[ ( 5 + 5 - 2 ] * 5";
      string4 = "13 - [ ( 6 + 18 ) / 3 * 22";
      string5 = "[ 4 / ( 12 - 8 / 4 * 25 ]";
      /*
[ 2 + 3 * 8 - 3 ) ] + 6
[ ( 2 - 5 ) + 6
[ ( 5 + 5 - 2 ] * 5
13 - [ ( 6 + 18 ) / 3 * 22
[ 4 / ( 12 - 8 / 4 * 25 ]
       */
    }
    // actually run functions
    (new Enclosure(string1)).run();
    (new Enclosure(string2)).run();
    (new Enclosure(string3)).run();
    (new Enclosure(string4)).run();
    (new Enclosure(string5)).run();
  }
}