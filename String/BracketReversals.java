package String;

public class BracketReversals {
    public int countMinReversals(String expr) {
        int len = expr.length();
        if (len % 2 != 0) return -1;  // Odd length can't be balanced

        int open = 0, close = 0;

        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);
            if (ch == '{') {
                open++;
            } else {
                if (open > 0) {
                    open--;  // Match with an opening
                } else {
                    close++; // Unmatched closing bracket
                }
            }
        }

        // Now we have `open` unmatched '{' and `close` unmatched '}'
        return (open + 1) / 2 + (close + 1) / 2;
    }

    public static void main(String[] args) {
        BracketReversals br = new BracketReversals();
        System.out.println(br.countMinReversals("}{{}}{{{")); // Output: 3
        System.out.println(br.countMinReversals("{{{{"));      // Output: 2
        System.out.println(br.countMinReversals("{{{"));       // Output: -1
    }
}
