public class Strings {
    // ACSL STRINGS
    // 1. char_split (a$, n, ‘char’) – char_split divides a given string (a$) into
    // substrings of length n separated by
    public static String char_split(String a$, int n, char c) {
        String result = "";
        for (int i = 0; i < a$.length(); i++) {
            if (i % n == 0 && i != 0) {
                result += c;
            }
            result += a$.charAt(i);
        }
        return result;
    }

    // 2. strrem (a$, b$) – removes all occurrences of b$
    public static String strrem(String a$, String b$) {
        String result = "";
        for (int i = 0; i < a$.length(); i++) {
            if (i + b$.length() <= a$.length()) {
                if (a$.substring(i, i + b$.length()).equals(b$)) {
                    i += b$.length() - 1;
                } else {
                    result += a$.charAt(i);
                }
            } else {
                result += a$.charAt(i);
            }
        }
        return result;
    }

    // 3. strchr (a$, b$) – strchr searches a$ for the first occurrence of b$ and
    // returns the characters of a$ before the first occurrence of b$
    public static String strchr(String a$, String b$) {
        String result = "";
        for (int i = 0; i < a$.length(); i++) {
            if (i + b$.length() <= a$.length()) {
                if (a$.substring(i, i + b$.length()).equals(b$)) {
                    return result;
                } else {
                    result += a$.charAt(i);
                }
            } else {
                result += a$.charAt(i);
            }
        }
        return result;
    }

    // 4. strtok(a$, b$) – strtok splits a given string (a$) into substrings each
    // time the character b$ is found. Substrings must be separated by spaces.
    public static String strtok(String a$, String b$) {
        String result = "";
        for (int i = 0; i < a$.length(); i++) {
            if (a$.charAt(i) == b$.charAt(0))
                result += " ";
            result += a$.charAt(i);
        }
        return result;
    }

    // 5. wordwrap(a$, n, b$) – wordwrap outputs the substrings of a$ that are a
    // maximum of n characters in length or that begin with the character b$.
    // Substrings must be separated by spaces.
    public static String wordwrap(String a$, int n, String b$) {
        String result = "";
        int count = 0;
        for (int i = 0; i < a$.length(); i++) {
            if (count == n) {
                result += " ";
                count = 0;
            }
            if (a$.charAt(i) == b$.charAt(0)) {
                result += " ";
                count = 0;
            }
            result += a$.charAt(i);
            count++;
        }
        return result;
    }
}
