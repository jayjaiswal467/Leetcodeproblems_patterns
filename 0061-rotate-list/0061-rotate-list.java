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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null){
            return null;
        }

        //pehle no.of node aur last element nikalna hai isiliye maanle sirf 1 hi node hai .. 
        int n=1;
        ListNode last = head;
        while(last.next!=null){
            n++;
            last=last.next;
        }

        k=k%n;
        if(k==0){
            return head;
        }

        //abb n-kth element  nikalana hai
        int c = n-k;
        int count =1;
        ListNode t = head;

        while(t!=null){
            if(count==c){
                break;
            }
            count++;
            t=t.next;
        }
         //yaha par hume n-kth element mil chuka haii

        ListNode res = t.next; //res = n-k+1th element
        last.next=head;
        t.next=null;

    return res;
    }
}