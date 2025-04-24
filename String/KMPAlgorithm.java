package String;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    // Step 1: Build LPS array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Step 2: Search using LPS array
    public static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> matchIndices = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                matchIndices.add(i - j);
                j = lps[j - 1]; // Continue checking for overlapping patterns
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Fallback
                } else {
                    i++;
                }
            }
        }

        return matchIndices;
    }

    public static void main(String[] args) {
        String text = "ABABABABA";
        String pattern = "ABABA";
        List<Integer> matches = KMPSearch(text, pattern);
        System.out.println("Pattern found at indices: " + matches);
    }
}
