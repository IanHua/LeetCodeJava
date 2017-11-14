class Solution {
    private boolean backtrack(char[][] board, int row, int col, int i, int j, String word,  boolean[][] visited) {
        if (word.isEmpty()) return true;
        char target = word.charAt(0);
        if (target != board[i][j]) return false;
        String left = word.substring(1);
        if (left.isEmpty()) return true;
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i-1][j]) {
            if (backtrack(board, row, col, i - 1, j, left, visited)) return true;
        }
        if (i + 1 < row && !visited[i+1][j]) {
            if (backtrack(board, row, col, i + 1, j, left, visited)) return true;
        }
        if (j - 1 >= 0 && !visited[i][j-1]) {
            if (backtrack(board, row, col, i, j - 1, left, visited)) return true;
        }
        if (j + 1 < col && !visited[i][j+1]) {
            if (backtrack(board, row, col, i, j + 1, left, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) return false;
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        if (col == 0) return false;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, row, col, i, j, word, visited)) return true;
            }
        }
        return false;
    }
}