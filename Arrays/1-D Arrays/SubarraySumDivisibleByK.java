import java.util.*;

public class SubarraySumDivisibleByK {
    public static int subarraySumDivisibleByK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remainder = sum % k;

            if(remainder < 0){
                remainder = remainder + k;
            }
            if(map.containsKey(remainder)){
                count+= map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int ans = subarraySumDivisibleByK(arr, k);
        System.out.println("The number of subarrays sum divisible by k is: " + ans);
    }
}