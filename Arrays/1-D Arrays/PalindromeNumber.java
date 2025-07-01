public class PalindromeNumber {

    // Method to check if number is a palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;             // Get last digit
            reversed = reversed * 10 + digit; // Add digit to reversed
            num = num / 10;                   // Remove last digit
        }

        // Compare reversed number to original
        return original == reversed;
    }

    public static void main(String[] args) {
        int number = 121;

        if (isPalindrome(number)) {
            System.out.println(number + " is a Palindrome.");
        } else {
            System.out.println(number + " is NOT a Palindrome.");
        }
    }
}
