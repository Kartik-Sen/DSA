import java.util.*;

public class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums, int n) {
        int c = 0;
        int prod = 1;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        // Calculate product of all non-zero elements and count zeros
        for (int num : nums) {
            if (num == 0)
                c++;
            else
                prod *= num;
        }

        // Generate the result array
        for (int i = 0; i < n; i++) {
            if (c > 1)
                res[i] = 0;
            else if (c == 1) {
                if (nums[i] == 0)
                    res[i] = prod;
                else
                    res[i] = 0;
            } else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6, 2};
        int[] result = productExceptSelf(nums, nums.length);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
