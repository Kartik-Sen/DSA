import java.util.*;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        // Sort both the greed array and the size array
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0; // pointer for children
        int cookie = 0; // pointer for cookies
        int contentChildren = 0;
        
        // Traverse through all the cookies and try to satisfy children
        while (child < g.length && cookie < s.length) {
            // If the cookie can satisfy the child, assign it
            if (s[cookie] >= g[child]) {
                contentChildren++;  // One more child is satisfied
                child++;  // Move to the next child
            }
            cookie++;  // Move to the next cookie, whether or not it was assigned
        }
        
        return contentChildren;
    }

    public static void main(String[] args) {
        // Example input
        int[] g = {1, 2, 3};  // Greed factors of children
        int[] s = {1, 1};  // Sizes of cookies
        
        int result = findContentChildren(g, s);
        System.out.println("Number of content children: " + result);  // Output: 1
    }
}
