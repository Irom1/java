public class Enclosure {
    private String cleanedString;
    private char addingChar;

    // create a constructor
    public Enclosure(String string) {
        cleanedString = Strings.strrem(string, " ");
        addingChar = '(';
        addingChar = findUnbalancedIndex(cleanedString); // sets addingChar to appropriate value
    }

    // create a method to run the program
    public void run() {
        // run code
        String validLocations = findAllValidLocations();
        /* debug info
        System.out.println();
        System.out.println("Initial string: " + cleanedString);
        System.out.println("Char to be added: " + addingChar);
        // */
        System.out.println(validLocations);
    }

    // create a method to find the point where the string is unbalanced
    private char findUnbalancedIndex(String s) {
        String cleanedString = s;
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
        return reverseChar(opener);
        // return unbalancedIndex;
    }

    private String findAllValidLocations() {
        String validLocations = "";
        for (int i = 0; i < cleanedString.length() + 1; i++) {
            String testString = cleanedString.substring(0, i) + addingChar + cleanedString.substring(i);
            boolean isValid = isValid(testString);
            if (isValid) {
                if (validLocations.length() > 0) {
                    validLocations += ", ";
                }
                validLocations += i + 1;
            }
        }
        return validLocations;
    }

    private boolean isValid(String full) {
        full = " " + full + " ";
        boolean valid = true;
        int i = 1;
        while (valid && i < full.length() - 1) {
            // establish current, previous, and next chars
            char current = full.charAt(i);
            char previous = full.charAt(i - 1);
            char next = full.charAt(i + 1);
            // checks
            if (current == ')' || current == ']') {
                char oposite = reverseChar(current);
                String segment = full.substring(0, i);
                int index = segment.lastIndexOf(oposite);
                if (index == -1) {
                    // enclosure doesn't have an opener
                    valid = false;
                } else {
                    segment = segment.substring(index);
                    if (segment.indexOf('+') == -1 && segment.indexOf('-') == -1 && segment.indexOf('*') == -1
                            && segment.indexOf('/') == -1) {
                        // enclosure doesn't have an operator inside
                        valid = false;
                    }
                    if (current == ')') {
                        if (segment.indexOf('[') != -1 || segment.indexOf(']') != -1) {
                            // enclosure has another enclosure inside which is invalid
                            valid = false;
                        }
                    }
                }
            }
            // check that enclosure symbols are on appropriate side of operators
            if (
                ((current == ')' || current == ']') && charIsOperator(previous)) ||
                ((current == '(' || current == '[') && charIsOperator(next))
            ) {
                valid = false;
            }
            // check that operator isn't breaking up a two digit number
            if ((current == ')' || current == ']' || current == '(' || current == '[') && charIsNumber(previous) && charIsNumber(next)) {
                valid = false;
            }
            // increase index
            i++;
        }
        if (valid) {
            //System.out.println("Valid: " + full);
        }
        return valid;
    }

    private char reverseChar(char c) {
        String enclosures = "[]()";
        String opposites = "][)(";
        return opposites.charAt(enclosures.indexOf(c));
    }

    private boolean charIsOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == ' ';
    }

    private boolean charIsNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
