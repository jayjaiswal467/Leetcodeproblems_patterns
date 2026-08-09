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

    // Reverse 'times' nodes starting from head
    public ListNode reverse(ListNode head, int times) {

        ListNode curr = head;
        ListNode prev = null;

        while (times-- > 0) {
            ListNode n = curr.next;

            curr.next = prev;
            prev = curr;
            curr = n;
        }

        // head is now the last node of reversed part
        head.next = curr;

        return prev;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int size = 2;

        ListNode left = head;
        ListNode right;
        ListNode prevleft = null;
        ListNode res = null;

        while (true) {

            right = left;

            // Find the second node of the pair
            for (int i = 0; i < size - 1; i++) {

                if (right == null) {
                    break;
                }

                right = right.next;
            }

            // No complete pair available
            if (right == null) {
                break;
            }

            // Save node after the pair
            ListNode nextleft = right.next;

            // Reverse the pair
            ListNode newHead = reverse(left, size);

            // Connect previous pair to current pair
            if (prevleft != null) {
                prevleft.next = newHead;
            }

            // First pair's new head
            if (res == null) {
                res = newHead;
            }

            // After reversal, 'left' is the last node
            prevleft = left;

            // Move to next pair
            left = nextleft;
        }

        // If there is an unpaired node, connect it
        if (prevleft != null && left != null) {
            prevleft.next = left;
        }

        return res;
    }
}