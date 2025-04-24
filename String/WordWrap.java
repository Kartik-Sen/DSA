package String;

public class WordWrap {
    public int solveWordWrap(int[] words, int maxWidth) {
        int n = words.length;
        int[] dp = new int[n + 1];  // dp[i] = min cost to wrap words[i...n-1]
        int[] nextBreak = new int[n]; // Optional: for tracking line breaks (not required for cost)
        
        // Start from the end and calculate cost backwards
        for (int i = n - 1; i >= 0; i--) {
            int currLen = -1;
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                currLen += words[j] + 1;  // 1 for space
                if (currLen - 1 > maxWidth) break;

                int cost;
                if (j == n - 1) {
                    cost = 0;  // No cost on last line
                } else {
                    int extraSpaces = maxWidth - (currLen - 1);
                    cost = extraSpaces * extraSpaces + dp[j + 1];
                }

                if (cost < dp[i]) {
                    dp[i] = cost;
                    nextBreak[i] = j + 1;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        WordWrap wwo = new WordWrap();
        int[] words = {3, 2, 2, 5};
        int maxWidth = 6;
        System.out.println("Minimum total cost: " + wwo.solveWordWrap(words, maxWidth));
    }
}
