class Solution {
 private int rows;
    private int cols;
    private int[][] memo;
    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        int longest = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                longest = Math.max(longest, dfs(matrix, row, col));
            }
        }
        return longest;
    }
    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int best = 1;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rows
                    && nextCol >= 0 && nextCol < cols
                    && matrix[nextRow][nextCol] > matrix[row][col]) {
                best = Math.max(
                    best,
                    1 + dfs(matrix, nextRow, nextCol)
                );
            }
        }
        memo[row][col] = best;
        return best;
    }
}
