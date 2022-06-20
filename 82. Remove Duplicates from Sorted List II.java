// solution 1
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre  = dummyNode;
        ListNode cur  = head;
        
        while (cur!=null ) {
            while (cur.next !=null && cur.val == cur.next.val)
                cur = cur.next;
            if (pre.next ==cur)
                pre = pre.next;
            else
                pre.next = cur.next;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
//solution 2
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        
        if(head.val!=head.next.val){
            head.next=deleteDuplicates(head.next);
            return head;
        }
        else{
            while(head.next!=null&&head.val==head.next.val)
                head=head.next;
            
            return   deleteDuplicates(head.next);
        }
        
    }
}
