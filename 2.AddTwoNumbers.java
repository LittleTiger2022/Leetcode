class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0), cur= new ListNode(0);
        pre = cur;
        int carry = 0, num=0;
        while (l1!=null || l2 !=null) {
            num= carry;
            if (l1 !=null) {
                num+= l1.val;
                l1 = l1.next;
            }
            if (l2 !=null) {
                num+=l2.val;
                l2 = l2.next;
            }
            
            cur.next = new ListNode(num%10);
            cur = cur.next;
            carry = num /10;
        }
        if (carry>0)
            cur.next = new ListNode(carry);
        return pre.next;
    }
}
