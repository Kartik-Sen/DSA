package String;

public class LongestPrefixSuffix {
    public static int longestPrefixSuffix(String s) {
        int n = s.length();
        
        // lps[] will hold the longest prefix suffix values for pattern
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[n - 1]; // length of the longest prefix which is also a suffix
    }

    public static void main(String[] args) {
        String input = "blablabla";
        int len = longestPrefixSuffix(input);
        System.out.println("Length of the longest prefix which is also a suffix: " + len);
    }
}
