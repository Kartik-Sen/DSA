package String;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; // ASCII size
        for (int i = 0; i < 128; i++) lastSeen[i] = -1;

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(input));
    }
}
