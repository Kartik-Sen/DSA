package String;

public class NextPermutation {
    public static String nextPermutation(String s) {
        char[] chars = s.toCharArray();

        int i = chars.length - 2;
        // Step 1: Find the first character that is smaller than its next character
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the next greater character to swap with
            int j = chars.length - 1;
            while (chars[j] <= chars[i]) {
                j--;
            }
            swap(chars, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(chars, i + 1, chars.length - 1);

        return new String(chars);
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }

    public static void main(String[] args) {
        String input = "hefg";
        System.out.println("Next permutation: " + nextPermutation(input));
    }
}
