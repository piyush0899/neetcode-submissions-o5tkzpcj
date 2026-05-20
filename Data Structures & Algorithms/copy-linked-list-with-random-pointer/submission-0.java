/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
      public Node copyRandomList(Node head) {

        if (head == null) return null;

        // old node -> new node
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Step 1: create copy nodes
        while (curr != null) {

            map.put(curr, new Node(curr.val));

            curr = curr.next;
        }

        curr = head;

        // Step 2: connect next and random
        while (curr != null) {

            Node copy = map.get(curr);

            copy.next = map.get(curr.next);

            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
