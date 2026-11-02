class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        // dp[i] = maximum score difference current player can achieve
        // compared to the other player, starting from index i
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int stonesSum = 0;
            dp[i] = Integer.MIN_VALUE;

            // Current player can take 1, 2, or 3 stones
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                stonesSum += stoneValue[i + k - 1];

                // Current player's stones sum minus opponent's best difference
                dp[i] = Math.max(dp[i], stonesSum - dp[i + k]);
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}