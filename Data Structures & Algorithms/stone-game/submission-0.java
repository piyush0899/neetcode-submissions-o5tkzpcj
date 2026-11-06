class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        // dp[i][j] = maximum score difference
        // current player can achieve from piles[i...j]
        int[][] dp = new int[n][n];

        // Base case: only one pile is left
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Calculate for increasing interval lengths
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length <= n; i++) {
                int j = i + length - 1;

                // Choose the first pile
                int takeFirst = piles[i] - dp[i + 1][j];

                // Choose the last pile
                int takeLast = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeFirst, takeLast);
            }
        }

        return dp[0][n - 1] > 0;
    }
}