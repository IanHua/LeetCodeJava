class NumMatrix {

    private int[][] tree;
    
    private int[][] nums;
    
    private int n;
    
    private int m;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        n = matrix.length;
        m = matrix[0].length;
        nums = new int[n][m];
        tree = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= n; i += (i & (-i))) {
            for (int j = col + 1; j <= m; j += (j & (-j))) {
                tree[i][j] += delta;
            }
        }
    }
    
    public int getSum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & (-i))) {
            for (int j = col; j > 0; j -= (j & (-j))) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row2 + 1, col1) - getSum(row1, col2 + 1) + getSum(row1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */