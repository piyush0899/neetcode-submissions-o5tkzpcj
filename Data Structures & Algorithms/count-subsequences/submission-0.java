class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] = ways to form t[0...j-1]
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty t can always be formed once

        for (int i = 1; i <= m; i++) {
            // Traverse backward so each s character is used only once
            for (int j = Math.min(i, n); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}