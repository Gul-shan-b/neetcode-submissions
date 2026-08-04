class Solution {

    int count = 0;

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board);

        return count;
    }

    private void backtrack(int row, char[][] board) {

        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {

                board[row][col] = 'Q';

                backtrack(row + 1, board);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {

        // Check column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q')
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}