class Solution {
 public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // top and bottom rows
        for (int c = 0; c < cols; c++) {

            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }

        // left and right columns
        for (int r = 0; r < rows; r++) {

            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }

        // convert cells
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {

                    board[r][c] = 'X';

                } else if (board[r][c] == 'T') {

                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board,
                     int r,
                     int c) {

        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 ||
            c < 0 ||
            r >= rows ||
            c >= cols ||
            board[r][c] != 'O') {

            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
