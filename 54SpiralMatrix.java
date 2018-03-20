public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        if (n == 0) return ans;
        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // right
            for (int j = colBegin; j <= colEnd; j++) {
                ans.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            // down
            for (int i = rowBegin; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            // left
            for (int j = colEnd; rowBegin <= rowEnd && j >= colBegin; j--) {
                ans.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            // up
            for (int i = rowEnd; colBegin <= colEnd && i >= rowBegin; i--) {
                ans.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return ans;
    }
}