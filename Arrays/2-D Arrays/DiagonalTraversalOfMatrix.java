public class DiagonalTraversalOfMatrix {
    public static int[] diagonalTraversal(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int row = 0;
        int col = 0;

        int[] ans = new int[n*m];
        int idx = 0;

        boolean up = true;

        while (row < m && col < n){
            if(up == true){
                while (row > 0 && col < n-1){
                    ans[idx++] = arr[row][col];
                    row--;
                    col++;
                }
                ans[idx++] = arr[row][col];
                if(col == n-1){
                    row++;
                }
                else{
                    col++;
                }
            }
            else{
                while (row < m-1 && col > 0){
                    ans[idx++] = arr[row][col];
                    row++;
                    col--;
                }
                ans[idx++] = arr[row][col];
                if(row == m-1){
                    col++;
                }
                else{
                    row++;
                }
            }
            up = !up;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalTraversal(arr));
    }
}


