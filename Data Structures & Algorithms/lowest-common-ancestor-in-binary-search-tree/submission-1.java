/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode roots, TreeNode p, TreeNode q) {
       while (roots != null) {

        if (p.val < roots.val && q.val < roots.val) {
            roots = roots.left;
        } 
        else if (p.val > roots.val && q.val > roots.val) {
            roots = roots.right;
        } 
        else {
            return roots; // LCA found
        }
    }

    return null;
    }
}
