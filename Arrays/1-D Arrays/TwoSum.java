import java.util.*;

public class TwoSum {
    static void twoSum(int[] arr, int target){

        // Create a HashMap to store the elements
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {

            // Calculate the complement that added to
            // arr[i], equals the target
            int complement = target - arr[i];

            // Check if the complement exists in the Map
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement)+","+i);
            }

            // Add the current element to the Map
            map.put(arr[i], i);
        }
    }

    public static void main(String[] args){

        int[] arr = { 16,4,23,8,15,42,1,2};
        int target = 19;

        // Call the twoSum function
        twoSum(arr, target);
    }
}  
