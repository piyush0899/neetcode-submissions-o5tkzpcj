class Solution {

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n - 1];
        boolean[] diagonals2 = new boolean[2 * n - 1];

        return backtrack(0, n, columns, diagonals1, diagonals2);
    }

    private int backtrack(
            int row,
            int n,
            boolean[] columns,
            boolean[] diagonals1,
            boolean[] diagonals2) {

        // All queens have been placed successfully
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            int diagonal1 = row - col + n - 1;
            int diagonal2 = row + col;

            // Check whether this position is safe
            if (columns[col]
                    || diagonals1[diagonal1]
                    || diagonals2[diagonal2]) {
                continue;
            }

            // Place queen
            columns[col] = true;
            diagonals1[diagonal1] = true;
            diagonals2[diagonal2] = true;

            // Move to the next row
            count += backtrack(
                    row + 1,
                    n,
                    columns,
                    diagonals1,
                    diagonals2
            );

            // Backtrack: remove queen
            columns[col] = false;
            diagonals1[diagonal1] = false;
            diagonals2[diagonal2] = false;
        }

        return count;
    }
}