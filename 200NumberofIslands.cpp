class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int ans = 0;
        int row = grid.size();
        if (row == 0) return 0;
        int col = grid[0].size();
        if (col == 0) return 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, row, col, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    void DFS(vector<vector<char>>& grid, int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >=col || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFS(grid, row, col, i + 1, j);
        DFS(grid, row, col, i - 1, j);
        DFS(grid, row, col, i, j + 1);
        DFS(grid, row, col, i, j - 1);
    }
};