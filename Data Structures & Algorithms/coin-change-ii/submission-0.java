class Solution {
Integer[][] dp;

    public int change(int amount, int[] coins) {

        dp = new Integer[coins.length][amount + 1];

        return dfs(0, amount, coins);
    }

    private int dfs(int index,
                    int amount,
                    int[] coins) {

        if (amount == 0)
            return 1;

        if (amount < 0 || index == coins.length)
            return 0;

        if (dp[index][amount] != null)
            return dp[index][amount];

        int take = dfs(index,
                amount - coins[index],
                coins);

        int skip = dfs(index + 1,
                amount,
                coins);

        dp[index][amount] = take + skip;

        return dp[index][amount];
    }
}
