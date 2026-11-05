class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        // dp[i] = whether we can form sum i
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int stone : stones) {
            // Reverse traversal to use each stone only once
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the largest achievable sum <= target
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return totalSum - 2 * i;
            }
        }

        return 0;
    }
}