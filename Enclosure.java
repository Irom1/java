public class Enclosure {
    private String cleanedString;
    private char addingChar;

    // create a constructor
    public Enclosure(String string) {
        cleanedString = Strings.strrem(string, " ");
        addingChar = '(';
    }

    // create a method to run the program
    public void run() {
        System.out.println();
        // find the point where the string is unbalanced
        int unbalancedIndex = findUnbalancedIndex();
        System.out.println(cleanedString);
        System.out.println(unbalancedIndex);
        System.out.println(addingChar);
        // get the part of the string before the unbalanced point
        String newPart = cleanedString.substring(0, unbalancedIndex);
        if(addingChar == ')' || addingChar == ']') {
            newPart = cleanedString.substring(unbalancedIndex);
        }
        System.out.println(newPart);
        // find places to add the char
        //
    }

    // create a method to find the point where the string is unbalanced
    private int findUnbalancedIndex() {
        String openChars = "";
        int unbalancedIndex = -1;
        int i = 0;
        while (unbalancedIndex == -1 && i < cleanedString.length()) {
            char current = cleanedString.charAt(i);
            if (current == '(' || current == '[') {
                openChars += current;
            } else if (current == ')' || current == ']') {
                // search for pair in openChars
                int foundIndex = openChars.lastIndexOf(reverseChar(current));
                if (foundIndex == -1) {
                    // found no pair
                    unbalancedIndex = i;
                } else {
                    // remove char at foundIndex from openChars
                    openChars = openChars.substring(0, foundIndex) + openChars.substring(foundIndex + 1);
                }
            }
            i++;
        }
        if (unbalancedIndex == -1) {
            unbalancedIndex = cleanedString.lastIndexOf(openChars);
        }
        char opener = cleanedString.charAt(unbalancedIndex);
        addingChar = reverseChar(opener);
        return unbalancedIndex;
    }

    private char reverseChar(char c) {
        String enclosures = "[]()";
        String opposites = "][)(";
        return opposites.charAt(enclosures.indexOf(c));
    }
}
