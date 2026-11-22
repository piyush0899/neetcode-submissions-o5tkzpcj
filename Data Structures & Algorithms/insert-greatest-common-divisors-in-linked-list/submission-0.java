
class Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {

            ListNode curr = head;

                    while (curr != null && curr.next != null) {

                                int gcd = findGCD(curr.val, curr.next.val);

                                            ListNode newNode = new ListNode(gcd);

                                                        // Insert new node between current and next
                                                                    newNode.next = curr.next;
                                                                                curr.next = newNode;

                                                                                            // Move to the next original node
                                                                                                        curr = newNode.next;
                                                                                                                }

                                                                                                                        return head;
                                                                                                                            }

                                                                                                                                private int findGCD(int a, int b) {

                                                                                                                                        while (b != 0) {
                                                                                                                                                    int temp = b;
                                                                                                                                                                b = a % b;
                                                                                                                                                                            a = temp;
                                                                                                                                                                                    }

                                                                                                                                                                                            return a;
                                                                                                                                                                                                }
                                                                                                                                                                                                }
                                                                                                                                                                                                