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
    
    
    
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> ls = new ArrayList<>();
        if(root==null) return ls;
        rightview(root,ls,0);
        return ls;

    }

    public void rightview(TreeNode root, List<Integer> ls , int val){
        if(root == null){
            return;
        }

        if(ls.size() == val)
        {
            ls.add(root.val);
        }
        rightview(root.right,ls,val+1);
        rightview(root.left,ls,val+1);
    }
}
