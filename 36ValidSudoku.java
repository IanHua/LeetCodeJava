class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) return false;
        if (board[0].length != 9) return false;
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();
        HashSet<Character> cube = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            rows.clear();
            cols.clear();
            cube.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int rowidx = 3 * (i / 3);
                int colidx = 3 * (i % 3);
                if (board[rowidx+j/3][colidx+j%3] != '.' && !cube.add(board[rowidx+j/3][colidx+j%3])) return false;
            }
        }
        return true;
    }
}