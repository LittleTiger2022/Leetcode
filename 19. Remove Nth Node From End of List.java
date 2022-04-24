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
// 0ms. typical trick, add a dummy ListNode at the begining, and use two points (left & right), with step to be n.
// loop to the end of head, and left skips the n-th item (backward from the right), and return dummy.next as the solution.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        int shift = n;
        while(right!=null & shift>0) {
            right = right.next;
            shift--;
        }
        while (right!=null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
