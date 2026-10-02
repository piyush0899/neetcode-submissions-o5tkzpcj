class Solution {

    public int rob(TreeNode root) {

        int[] result = solve(root);

        // Either rob root or skip root
        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode root) {

        // Empty node
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get result from left subtree
        int[] left = solve(root.left);

        // Get result from right subtree
        int[] right = solve(root.right);

        // Case 1: Rob current node
        int robCurrent = root.val + left[1] + right[1];

        // Case 2: Skip current node
        int skipCurrent =
                Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{robCurrent, skipCurrent};
    }
}