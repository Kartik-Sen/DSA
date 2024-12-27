public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        // Create a DP array to store the minimum number of coins for each amount up to 'amount'
        int[] dp = new int[amount + 1];
        
        // Initialize dp array with a large number (infinity)
        // Use amount + 1 as a "infinity" value (impossible to make amount with the given coins)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Base case: dp[0] = 0 (0 coins needed to make amount 0)
        dp[0] = 0;

        // Loop through all the coin denominations
        for (int coin : coins) {
            // Update the DP table for each amount from coin to the target 'amount'
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still the initial large value, return -1 (impossible to make amount)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Example usage
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);
        System.out.println("Minimum number of coins: " + result);  // Output: 3
    }
}
