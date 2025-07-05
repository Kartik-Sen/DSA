public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Padding nums with 1 at both ends
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // DP table
        int[][] dp = new int[n + 2][n + 2];

        // Build the table using bottom-up DP
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            balloons[left - 1] * balloons[i] * balloons[right + 1]
                            + dp[left][i - 1] + dp[i + 1][right]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println("Max coins: " + bb.maxCoins(nums));  // Output: 167
    }
}
