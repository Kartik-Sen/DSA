package String;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLeft = 0, minLen = Integer.MAX_VALUE;
        int required = targetCount.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCounts.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < targetCount.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    // Test method
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);  // Output: BANC
    }
}
