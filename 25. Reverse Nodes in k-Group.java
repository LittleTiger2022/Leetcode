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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k<2 ) return head;
        ListNode pre = new ListNode(0), cur, tail, dummy = new ListNode(0);
        dummy.next = head;
        pre = dummy;
        tail = dummy;
        while(true) {
            int n = 0;
            while (n++ <k && tail !=null)
                tail = tail.next;
            if (tail==null) break;
            head = pre.next;
            while(pre.next!=tail) {
                cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head;
            tail = head;
        }
        return dummy.next;
    }
}
