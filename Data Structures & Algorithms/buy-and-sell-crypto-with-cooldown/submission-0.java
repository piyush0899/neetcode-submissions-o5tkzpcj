class Solution {
public int maxProfit(int[] prices) {
        return dfs(0, 1, prices);
    }

    private int dfs(int day, int buy, int[] prices) {

        if (day >= prices.length)
            return 0;

        if (buy == 1) {

            int buyStock = -prices[day] + dfs(day + 1, 0, prices);

            int skip = dfs(day + 1, 1, prices);

            return Math.max(buyStock, skip);

        } else {

            int sell = prices[day] + dfs(day + 2, 1, prices);

            int hold = dfs(day + 1, 0, prices);

            return Math.max(sell, hold);
        }
    }
}
