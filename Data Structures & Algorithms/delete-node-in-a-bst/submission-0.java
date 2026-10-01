class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        // Node not found
        if (root == null) {
            return null;
        }

        // Key is smaller, go to left subtree
        if (key < root.val) {

            root.left = deleteNode(root.left, key);
        }

        // Key is greater, go to right subtree
        else if (key > root.val) {

            root.right = deleteNode(root.right, key);
        }

        // We found the node
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}