package String;

public class WildcardStringMatching {
    static boolean wildCard(String txt, String pat) {
        int n = txt.length();  // Length of text
        int m = pat.length();  // Length of pattern
        int i = 0, j = 0, startIndex = -1, match = 0;

        // Loop through the text
        while (i < n) {

            // If characters match or pattern has '?', match any character
            if (j < m && (pat.charAt(j) == '?' || pat.charAt(j) == txt.charAt(i))) {
                i++;
                j++;
            }

            // If pattern has '*' (wildcard for zero or more characters)
            else if (j < m && pat.charAt(j) == '*') {
                startIndex = j;  // Remember the position of '*' in the pattern
                match = i;       // Mark the current position in the text
                j++;             // Move to the next pattern character
            }

            // If there's no match but we previously encountered '*'
            else if (startIndex != -1) {
                j = startIndex + 1;  // Backtrack to the position after '*'
                match++;             // Try to match one more character in the text
                i = match;           // Move the text pointer
            }

            // No match, and no previous '*' to backtrack to
            else {
                return false;
            }
        }

        // Consume any remaining '*' characters in the pattern
        while (j < m && pat.charAt(j) == '*') {
            j++;
        }

        // If we have processed the entire pattern, the match is successful
        return j == m;
    }

    public static void main(String[] args) {
        String txt = "baaabab";  // The text to match
        String pat = "*****ba*****ab";  // The pattern with wildcards

        // Output the result of matching
        System.out.println(wildCard(txt, pat) ? "true" : "false");  // Output: true
    }
}
