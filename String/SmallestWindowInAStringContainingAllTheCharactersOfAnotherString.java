package String;

import java.util.HashMap;

public class SmallestWindowInAStringContainingAllTheCharactersOfAnotherString {
    public static String smallestWindow(String s, String p)
    {
        int len1 = s.length();
        int len2 = p.length();

        // Check if string's length is less than P's length
        if (len1 < len2) {
            return "-1";
        }

        // Initialize hash maps for P and string S
        HashMap<Character, Integer> hashP = new HashMap<>();
        HashMap<Character, Integer> hashS = new HashMap<>();

        // Store occurrence of characters of P
        for (int i = 0; i < len2; i++) {
            hashP.put(p.charAt(i), hashP.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;
        int count = 0;

        // Start traversing the string S
        for (int j = 0; j < len1; j++) {
            // Count occurrence of characters of string S
            char currentChar = s.charAt(j);
            hashS.put(currentChar, hashS.getOrDefault(currentChar, 0) + 1);

            // If S's char matches with P's char, increment count
            if (hashP.containsKey(currentChar) && hashS.get(currentChar) <= hashP.get(currentChar)) {
                count++;
            }

            // If all characters are matched
            if (count == len2) {
                // Try to minimize the window
                while (hashS.getOrDefault(s.charAt(start), 0) > hashP.getOrDefault(s.charAt(start), 0) || !hashP.containsKey(s.charAt(start))) {
                    if (hashS.get(s.charAt(start)) > hashP.getOrDefault(s.charAt(start), 0)) {
                        hashS.put(s.charAt(start), hashS.get(s.charAt(start)) - 1);
                    }
                    start++;
                }

                // Update window size
                int len = j - start + 1;
                if (min_len > len) {
                    min_len = len;
                    // Update starting index
                    start_idx = start;
                }
            }
        }

        // If no window found
        if (start_idx == -1)
            return "-1";

        // Return the substring starting from start_idx and length min_len
        return s.substring(start_idx, start_idx + min_len);
    }

    public static void main(String[] args)
    {
        String s = "timetopractice";
        String p = "toc";

        String result = smallestWindow(s, p);
        System.out.println("Smallest window containing all characters: " + result);
    }
}
