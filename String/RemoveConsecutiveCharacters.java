package String;

public class RemoveConsecutiveCharacters {
    public static String removeConsecutive(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder result = new StringBuilder();
        char prev = s.charAt(0);  // First character always included
        result.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                result.append(curr);
                prev = curr;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeConsecutive("aaabbbcc"));  // "abc"
        System.out.println(removeConsecutive("aabbbaa"));   // "aba"
        System.out.println(removeConsecutive("abc"));       // "abc"
    }
}
