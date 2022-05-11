class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next ==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int n;
        for (n=0; fast.next!=null;n++)
            fast = fast.next;
        for (int j=n-k%n;j>0;j--)
            slow = slow.next;
        
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
}
