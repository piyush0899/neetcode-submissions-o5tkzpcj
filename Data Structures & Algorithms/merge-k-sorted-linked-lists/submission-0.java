/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> arr = new ArrayList<>();

        for(ListNode head : lists){

            while(head != null){
                arr.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(int num : arr){

            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }
}
