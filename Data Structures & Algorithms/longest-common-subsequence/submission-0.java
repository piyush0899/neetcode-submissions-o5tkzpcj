class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i, int j, String s1, String s2) {

        if (i == s1.length() || j == s2.length())
            return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + dfs(i + 1, j + 1, s1, s2);

        return Math.max(dfs(i + 1, j, s1, s2),
                        dfs(i, j + 1, s1, s2));
    }
}
