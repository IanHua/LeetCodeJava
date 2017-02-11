/**
 * 54. Spiral Matrix
 * Traverse as spiral pattern and keep updating row and col
 * O(n)
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = -1;
        int i;
        while (true) {
            for (i = 0; i < n; i++) {
                ans.add(matrix[row][++col]);
            }
            if (--m == 0) break;
            for (i = 0; i < m; i++) {
                ans.add(matrix[++row][col]);
            }
            if (--n == 0) break;
            for (i = 0; i < n; i++) {
                ans.add(matrix[row][--col]);
            }
            if (--m == 0) break;
            for (i = 0; i < m; i++) {
                ans.add(matrix[--row][col]);
            }
            if (--n == 0) break;
        }
        return ans;
    }
}