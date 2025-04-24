package String;

public class TransformOneStringToAnotherUsingMinimumNumberOfGivenOperation {
     // Function to return the minimum number of adjacent swaps
     public static int minOps(String A, String B) {

        // Step 1: Check if both strings are the same length
        if (A.length() != B.length())
            return -1;

        // Step 2: Check if both strings are anagrams
        int[] count = new int[256]; // For ASCII chars

        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0)
                return -1; // Not anagrams
        }

        int res = 0;
        int i = A.length() - 1;
        int j = B.length() - 1;

        // Step 3: Count mismatches by comparing from the end
        while (i >= 0) {
            if (A.charAt(i) != B.charAt(j)) {
                res++;  // One swap needed (bubble character to the correct position)
            } else {
                j--;    // Match found, move both pointers
            }
            i--;
        }

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        String A = "EACBD";
        String B = "EABCD";

        int result = minOps(A, B);

        if (result == -1) {
            System.out.println("Transformation not possible (not anagrams or unequal length)");
        } else {
            System.out.println("Minimum number of adjacent swaps required is " + result);
        }
    }
}
