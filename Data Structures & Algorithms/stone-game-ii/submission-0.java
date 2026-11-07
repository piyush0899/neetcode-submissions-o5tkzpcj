class Solution {
    int[][] dp;
    int[] suffixSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffixSum = new int[n + 1];

        // Calculate suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return solve(piles, 0, 1);
    }

    private int solve(int[] piles, int index, int M) {
        int n = piles.length;

        // All piles are taken
        if (index >= n) {
            return 0;
        }

        // If current player can take all remaining piles
        if (2 * M >= n - index) {
            return suffixSum[index];
        }

        // Return already calculated result
        if (dp[index][M] != 0) {
            return dp[index][M];
        }

        int maxStones = 0;

        // Current player can take 1 to 2*M piles
        for (int X = 1; X <= 2 * M; X++) {

            // Stones collected by current player
            int currentStones = suffixSum[index] -
                                suffixSum[index + X];

            // Opponent's maximum stones from remaining piles
            int opponentStones = solve(piles, index + X,
                                       Math.max(M, X));

            // Current player's total stones
            int totalStones = currentStones +
                              suffixSum[index + X] -
                              opponentStones;

            maxStones = Math.max(maxStones, totalStones);
        }

        dp[index][M] = maxStones;

        return maxStones;
    }
}