public class MinimumInRotatedSortedArray {
    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            // The current subarray is already sorted,
            // the minimum is at the low index
            if (arr[low] <= arr[high])
                return arr[low];

            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
            int mid = (low + high) / 2;

            // The right half is not sorted. So
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[high])
                low = mid + 1;

            // The right half is sorted. Note that in
            // this case, we do not change high to mid - 1
            // but keep it to mid. The mid element
            // itself can be the smallest
            else
                high = mid;
        }

        return arr[low];
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}