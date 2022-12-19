public class Enclosure {
    private String cleanedString;
    private char addingChar;
    private int startEnclosureIndex;
    private int endEnclosureIndex;

    // create a constructor
    public Enclosure(String string) {
        cleanedString = Strings.strrem(string, " ");
        addingChar = '(';
    }

    // create a method to run the program
    public void run() {
        boolean addCharToLeftSide = true;
        System.out.println();
        // find the point where the string is unbalanced
        int unbalancedIndex = findUnbalancedIndex();
        System.out.println("Initial string: " + cleanedString);
        //System.out.println(unbalancedIndex);
        System.out.println("Char to be added: " + addingChar);
        // get the part of the string before the unbalanced point
        String newPart = cleanedString.substring(0, unbalancedIndex);
        if(addingChar == ')' || addingChar == ']') {
            newPart = cleanedString.substring(unbalancedIndex);
            addCharToLeftSide = false;
        }
        System.out.println("Should be added to " + (addCharToLeftSide ? "left" : "right") + " side");
        //System.out.println(newPart);
        // find places to add the char
        String inside = findInside(newPart);
        System.out.println("Can be added in this segment: " + inside);
        System.out.println("Range start: " + startEnclosureIndex);
        System.out.println("Range end: " + endEnclosureIndex);
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
            startEnclosureIndex = unbalancedIndex;
            endEnclosureIndex = cleanedString.length() - 1;
        } else {
            endEnclosureIndex = unbalancedIndex;
            startEnclosureIndex = 0;
        }
        char opener = cleanedString.charAt(unbalancedIndex);
        addingChar = reverseChar(opener);
        return unbalancedIndex;
    }

    private String findInside(String outside) {
        String inside = "";
        inside = clean(outside, "(", true);
        inside = clean(inside, ")", false);
        inside = clean(inside, "[", true);
        inside = clean(inside, "]", false);
        // find indexes of first and last char of inside
        int firstIndex = outside.indexOf(inside);
        if(firstIndex == -1) System.out.println("firstIndex is -1");
        startEnclosureIndex += firstIndex;
        endEnclosureIndex = startEnclosureIndex + inside.length() - 1;
        return inside;
    }
    private String clean(String outside, String seperator, boolean rightSide) {
        String inside = "";
        int i = outside.indexOf(seperator);
        if (i != -1) {
            if (rightSide) {
                inside = outside.substring(i + 1);
            } else {
                inside = outside.substring(0, i);
            }
        } else {
            inside = outside;
        }
        return inside;
    }

    private char reverseChar(char c) {
        String enclosures = "[]()";
        String opposites = "][)(";
        return opposites.charAt(enclosures.indexOf(c));
    }
}
