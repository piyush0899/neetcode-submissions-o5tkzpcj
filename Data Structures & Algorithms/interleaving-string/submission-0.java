class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // Build s3 using only s2
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1]
                    && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            // Build s3 using only s1
            dp[0] = dp[0]
                    && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int index = i + j - 1;
                boolean takeFromS1 =
                        dp[j] && s1.charAt(i - 1) == s3.charAt(index);
                boolean takeFromS2 =
                        dp[j - 1] && s2.charAt(j - 1) == s3.charAt(index);
                dp[j] = takeFromS1 || takeFromS2;
            }
        }
        return dp[n];
    }
}
