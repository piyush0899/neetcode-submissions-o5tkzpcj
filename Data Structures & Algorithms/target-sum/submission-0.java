class Solution {
public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int required = total + target;
        // No valid subset is possible
        if (required < 0 || required % 2 != 0) {
            return 0;
        }
        required /= 2;
        int[] dp = new int[required + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int sum = required; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }
        return dp[required];
    }
}
