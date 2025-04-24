package String;

public class RabinKarpAlgorithmForPatternSearching {
    public static final int d = 256; // number of characters in input alphabet

    public static void rabinKarpSearch(String text, String pattern, int q) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate hash value for pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // If hash values match, check characters one by one
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // If t becomes negative, convert it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";
        int prime = 101; // A prime number for modulus

        rabinKarpSearch(text, pattern, prime);
    }
}
