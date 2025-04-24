package String;

import java.util.Arrays;

public class BoyerMooreAlgorithmForPatternSearching {
    private static final int NO_OF_CHARS = 256;

    // Builds the bad character heuristic table
    private int[] badCharHeuristic(String pattern) {
        int[] badChar = new int[NO_OF_CHARS];
        Arrays.fill(badChar, -1);  // Initialize all occurrences as -1

        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;  // Last occurrence of each character
        }

        return badChar;
    }

    public void search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        int[] badChar = badCharHeuristic(pattern);

        int s = 0;  // s is the shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j while characters of pattern and text are matching
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            if (j < 0) {
                // Match found at index s
                System.out.println("Pattern found at index " + s);

                // Shift pattern so the next character in text aligns with last occurrence in pattern
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                // Shift pattern so the bad character aligns with its last occurrence in pattern
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
    }

    public static void main(String[] args) {
        BoyerMooreAlgorithmForPatternSearching bm = new BoyerMooreAlgorithmForPatternSearching();
        String text = "ABAAABCD";
        String pattern = "ABC";
        bm.search(text, pattern);  // Output: Pattern found at index 4
    }
}
