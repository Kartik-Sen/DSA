package String;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);     // Odd-length palindromes
            count += expandFromCenter(s, i, i + 1); // Even-length palindromes
        }

        return count;
    }

    private static int expandFromCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "aaa";
        System.out.println("Number of palindromic substrings: " + countSubstrings(input));
    }
}
