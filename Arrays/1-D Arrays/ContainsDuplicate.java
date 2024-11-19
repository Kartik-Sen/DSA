import java.util.*;

public class ContainsDuplicate {
    static boolean checkDuplicates(int[] arr) {
        int n = arr.length;

        // Create a HashSet to store the unique elements
        Set<Integer> st = new HashSet<>();

        // Iterate through each element
        for (int i = 0; i < n; i++) {
              
            // If the element is already present, return true
            // Else insert the element into the set
            if (st.contains(arr[i]))
                return true;
            else
                st.add(arr[i]);
        }

        // If no duplicates are found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 4 };
        System.out.println(checkDuplicates(arr));
    }
}
