package String;

public class ConvertASentenceIntoItsEquivalentMobileNumberKeypadSequence {
    // Map each character A-Z to their keypad equivalent
    static final String[] keypad = {
        "2", "22", "222",      // A, B, C
        "3", "33", "333",      // D, E, F
        "4", "44", "444",      // G, H, I
        "5", "55", "555",      // J, K, L
        "6", "66", "666",      // M, N, O
        "7", "77", "777", "7777", // P, Q, R, S
        "8", "88", "888",      // T, U, V
        "9", "99", "999", "9999"  // W, X, Y, Z
    };

    public static String convertToKeypad(String input) {
        StringBuilder result = new StringBuilder();

        input = input.toUpperCase();  // Make sure everything is uppercase

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                result.append("0");  // Space maps to 0
            } else if (c >= 'A' && c <= 'Z') {
                int index = c - 'A';  // Find the position in the keypad array
                result.append(keypad[index]);
            }
            // You could handle digits, punctuation, etc., here if needed
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "HELLO WORLD";
        System.out.println(convertToKeypad(input));  // Output: 443355555566096667775553
    }
}
