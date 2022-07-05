// s1
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val==val? head.next: head;
    }
    public ListNode removeElement(ListNode head, int val) {
        ListNode pre = new ListNode(0), cur = pre;
        pre.next = head;
        while (cur.next!=null) {
            if (cur.next.val==val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return pre.next;
    }
}

// s2
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}
}
