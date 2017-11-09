class Solution {
    private void checkBoard(char[][] board, int row, int col, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i >= 1) checkBoard(board, row, col, i - 1, j);
            if (i < row - 1) checkBoard(board, row, col, i + 1, j);
            if (j >= 1) checkBoard(board, row, col, i, j - 1);
            if (j < col - 1) checkBoard(board, row, col, i, j + 1);
        }
        return;
    }
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        if (col == 0) return;
        // Check board
        for (int i = 0; i < row; i++) {
            checkBoard(board, row, col, i, 0);
            if (col > 1) checkBoard(board, row, col, i, col - 1);
        }
        for (int j = 1; j < col - 1; j++) {
            checkBoard(board, row, col, 0, j);
            if (row > 1) checkBoard(board, row, col, row - 1, j);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
        return;
    }
}