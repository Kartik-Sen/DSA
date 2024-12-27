public class ClimbingStairs {
    static int countWays(int n) {

        // variable prev1, prev2 - to store the
        // values of last and second last states
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        // In last iteration final value
        // of curr is stored in prev.
        return prev1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }
}
