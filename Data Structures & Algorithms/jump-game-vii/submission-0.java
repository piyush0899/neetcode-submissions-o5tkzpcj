class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];

        // Starting index is reachable
        dp[0] = true;

        // Count of reachable indices in the valid jump window
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            // Add the index that just entered the window
            int addIndex = i - minJump;

            if (addIndex >= 0 && dp[addIndex]) {
                reachableCount++;
            }

            // Remove the index that is now outside the window
            int removeIndex = i - maxJump - 1;

            if (removeIndex >= 0 && dp[removeIndex]) {
                reachableCount--;
            }

            // Current index is reachable if:
            // 1. Current character is '0'
            // 2. At least one reachable index exists in the window
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}