package String;

public class CountPalindromicSubsequences {
    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Expand window size from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Count of palindromic subsequences: " + countPalindromicSubsequences(s));
    }
}
