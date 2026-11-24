
class Main {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;

            for (int i = 0; i <= m - 3; i++) {
                for (int j = 0; j <= n - 3; j++) {
                    if (isMagicSquare(grid, i, j)) {
                        count++;
                    }
                }
            }

            return count;
        }

        private boolean isMagicSquare(int[][] grid, int r, int c) {
            if (grid[r + 1][c + 1] != 5) {
                return false;
            }

            boolean[] seen = new boolean[10];

            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    int num = grid[i][j];

                    if (num < 1 || num > 9 || seen[num]) {
                        return false;
                    }

                    seen[num] = true;
                }
            }

            for (int i = r; i < r + 3; i++) {
                if (grid[i][c] + grid[i][c + 1] + grid[i][c + 2] != 15) {
                    return false;
                }
            }

            for (int j = c; j < c + 3; j++) {
                if (grid[r][j] + grid[r + 1][j] + grid[r + 2][j] != 15) {
                    return false;
                }
            }

            int d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
            int d2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];

            return d1 == 15 && d2 == 15;
        }
    }
}
