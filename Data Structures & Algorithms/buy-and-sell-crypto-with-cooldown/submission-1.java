class Solution {
 Integer[][] dp;

    public int maxProfit(int[] prices) {

        dp = new Integer[prices.length][2];

        return dfs(0, 1, prices);
    }

    private int dfs(int day, int buy, int[] prices) {

        if (day >= prices.length)
            return 0;

        if (dp[day][buy] != null)
            return dp[day][buy];

        if (buy == 1) {

            int buyStock = -prices[day] + dfs(day + 1, 0, prices);

            int skip = dfs(day + 1, 1, prices);

            dp[day][buy] = Math.max(buyStock, skip);

        } else {

            int sell = prices[day] + dfs(day + 2, 1, prices);

            int hold = dfs(day + 1, 0, prices);

            dp[day][buy] = Math.max(sell, hold);
        }

        return dp[day][buy];
    }
}
