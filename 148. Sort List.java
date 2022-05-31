//  classical case for merge sort (归并排序)
// divide the listNode into two List, and sort each, then after merge
// O(nlogn)
class Solution {
    public ListNode sortList(ListNode head) {
        // seperate the ListNode into equal length subList
        if (head == null || head.next==null)
            return head;
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next= null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left,right);
    }
    ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l!=null || r!=null) {
            if (l==null) {
                cur.next = r;
                break;
            }
            if ( r== null) {
                cur.next=l;
                break;
            }
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
