class Solution {
    public int combinationSum4(int[] nums, int target) {

        // dp[i] = number of combinations that sum to i
        int[] dp = new int[target + 1];

        // One way to make target 0: choose nothing
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int num : nums) {

                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}