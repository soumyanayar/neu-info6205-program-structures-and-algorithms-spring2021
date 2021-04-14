package Assignment_07;

public class Problem1 {
    public void transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void mirror(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l - j - 1];
                matrix[i][l - j - 1] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        mirror(matrix);
    }
}
