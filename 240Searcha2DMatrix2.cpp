class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m == 0) return false;
        int n = matrix[0].size();
        if (n == 0 ) return false;
        int x = 0, y = n - 1;
        if (matrix[0][0] > target || matrix[m-1][n-1] < target) return false;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) y--;
            else x++;
        }
        return false;
    }
};