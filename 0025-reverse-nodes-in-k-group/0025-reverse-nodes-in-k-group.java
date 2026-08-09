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

    // Reverses exactly 'times' nodes
    public ListNode reverse(ListNode head, int times) {

        ListNode curr = head;
        ListNode prev = null;

        while (times-- > 0) {

            ListNode n = curr.next;

            curr.next = prev;

            prev = curr;

            curr = n;
        }

        head.next = curr;

        return prev;
    }


    // LeetCode calls this function
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int size = k;

        ListNode left = head;
        ListNode right;

        ListNode prevleft = null;

        ListNode res = null;


        while (true) {

            right = left;

            // Find kth node
            for (int i = 0; i < size - 1; i++) {

                if (right == null) {
                    break;
                }

                right = right.next;
            }


            // Not enough nodes for a complete group
            if (right == null) {
                break;
            }


            // Save beginning of next group
            ListNode nextleft = right.next;


            // Reverse current group
            ListNode newHead = reverse(left, size);


            // Connect previous group to current group
            if (prevleft != null) {
                prevleft.next = newHead;
            }


            // Store final head
            if (res == null) {
                res = newHead;
            }


            // 'left' becomes the last node
            // of the reversed group
            prevleft = left;


            // Move to next group
            left = nextleft;
        }


        // Connect remaining nodes
        // if their count is less than k
        if (prevleft != null && left != null) {
            prevleft.next = left;
        }


        return res;
    }
}