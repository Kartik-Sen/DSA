package String;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push open brackets onto stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check closing brackets
            else {
                if (stack.isEmpty()) return false; // No matching open bracket

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // All brackets should be matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("([)]"));   // false
        System.out.println(isValid("{[]}"));   // true
    }
}
