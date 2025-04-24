package String;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxCount = 0; // Count of the most frequent character in the window
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // If characters to replace > k, shrink window
            if (right - left + 1 - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest substring after replacements: " + characterReplacement(s, k));
    }
}
