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
        if (lists==null || lists.length==0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        return merge(lists,0,lists.length-1);
    }
    ListNode merge(ListNode[] lists, int i, int j) {
        if (j==i)
            return lists[i];
        ListNode l = merge(lists,i, (i+j)/2);
        ListNode r = merge(lists,(i+j)/2+1,j);
        return merge(l,r);
    }
    ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l!=null || r!=null) {
            if (l==null) {
                cur.next = r;
                break;
            }
            if (r==null) {
                cur.next = l;
                break;
            }
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            }
            else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        return dummy.next;
     } 
}
