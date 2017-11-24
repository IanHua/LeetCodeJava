class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        if (row != col) return;
        /*for (int i = 0; i < row / 2; i++) {
            for (int j = i; j < row - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row-1-j][i];
                matrix[row-1-j][i] = matrix[row-1-i][row-1-j];
                matrix[row-1-i][row-1-j] = matrix[j][row-1-i];
                matrix[j][row-1-i] = tmp;
            }
        }*/
        // Reverse rows
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row-1-i][j];
                matrix[row-1-i][j] = tmp;
            }
        }
        // Swap symmetry
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return;
    }
}