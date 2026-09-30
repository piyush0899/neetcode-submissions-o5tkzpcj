class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If we find an empty position,
        // insert the new node here
        if (root == null) {
            return new TreeNode(val);
        }

        // New value is smaller
        // so it should go to left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // New value is greater
        // so it should go to right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the original root
        return root;
    }
}