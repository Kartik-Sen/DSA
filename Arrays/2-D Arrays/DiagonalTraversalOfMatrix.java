import java.util.*;

public class DiagonalTraversalOfMatrix {
    public static int[] diagonalTraversal(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int row = 0;
        int col = 0;

        int[] ans = new int[m * n];
        int idx = 0;

        boolean up = true;

        while (idx < m * n) {
            ans[idx++] = arr[row][col];

            if (up) {
                if (col == n - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(diagonalTraversal(arr)));
    }
}
