// s1
// 22 ms (58%) 
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head ==null || head.next ==null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur!=null) {

            ListNode next = cur.next;


            while(pre.next!=null && pre.next.val<cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;

        }
        return dummy.next;
    }
}
