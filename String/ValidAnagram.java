package String;

public class ValidAnagram {
    public static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26]; // For 'a' to 'z'

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidAnagram("listen", "silent")); // true
        System.out.println(isValidAnagram("hello", "bello"));   // false
    }
}
