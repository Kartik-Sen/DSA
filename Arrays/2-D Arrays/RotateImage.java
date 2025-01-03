public class RotateImage {
    public static int[][] rotate(int[][] matrix) {

        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
          for (int j = i + 1; j < matrix.length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
          }
        }
    
        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length - j - 1];
            matrix[i][matrix.length - j - 1] = temp;
          }
        }
    
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(rotate(matrix));
    }
    
}
