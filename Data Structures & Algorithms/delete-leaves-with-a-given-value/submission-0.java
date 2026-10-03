class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        // Empty tree
        if (root == null) {
            return null;
        }

        // First process left subtree
        root.left = removeLeafNodes(root.left, target);

        // Then process right subtree
        root.right = removeLeafNodes(root.right, target);

        // Now check current node
        // It may have become a leaf after deleting children
        if (root.left == null
                && root.right == null
                && root.val == target) {

            return null;
        }

        return root;
    }
}