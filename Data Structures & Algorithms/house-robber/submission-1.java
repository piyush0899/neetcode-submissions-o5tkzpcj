class Solution {
    public int rob(int[] nums) {

        Integer[] dp =
                new Integer[nums.length];

        return helper(nums,
                      nums.length - 1,
                      dp);
    }

    private int helper(int[] nums,
                       int i,
                       Integer[] dp) {

        if (i < 0) return 0;

        if (dp[i] != null) {
            return dp[i];
        }

        int rob =
            nums[i] +
            helper(nums, i - 2, dp);

        int skip =
            helper(nums, i - 1, dp);

        return dp[i] =
                Math.max(rob, skip);
    }
}
