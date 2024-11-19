import java.util.*;

public class KthLargestElement {
    static int kthLargest(Integer[] arr, int K) {
      
        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());
      
        // Return K'th largest element
        return arr[K - 1];
    }

    public static void main(String[] args) {
        Integer[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.println(kthLargest(arr, K));
    }
}
