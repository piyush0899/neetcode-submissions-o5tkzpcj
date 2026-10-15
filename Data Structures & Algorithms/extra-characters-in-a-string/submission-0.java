

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();

        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));

        // dp[i] = minimum extra characters in s.substring(0, i)
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Initially, consider the current character as extra
            dp[i] = dp[i - 1] + 1;

            // Check all possible words ending at index i - 1
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);

                if (wordSet.contains(word)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}