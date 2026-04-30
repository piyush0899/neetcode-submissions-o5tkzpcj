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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // 🔹 Deserialize
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(arr));

        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> queue) {

        String val = queue.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = dfsDeserialize(queue);
        node.right = dfsDeserialize(queue);

        return node;
    }
}
